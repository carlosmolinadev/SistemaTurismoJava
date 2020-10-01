package sv.gob.mitur.application.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sv.gob.mitur.application.entities.Form;
import sv.gob.mitur.application.entities.Genders;
import sv.gob.mitur.application.entities.Roles;
import sv.gob.mitur.application.entities.User;
import sv.gob.mitur.application.services.implementations.DefaultService;
import sv.gob.mitur.application.services.implementations.EventService;
import sv.gob.mitur.application.services.implementations.FormService;
import sv.gob.mitur.application.services.implementations.LocationService;
import sv.gob.mitur.application.services.implementations.RouteService;
import sv.gob.mitur.application.services.implementations.TypeService;
import sv.gob.mitur.application.services.implementations.UserService;

/**
 * Controller for generic pages
 */
@Controller
public class DefaultController
{
	// Dependency injection
	@Autowired private LocationService	locationService;
	@Autowired private DefaultService	defaultService;
	@Autowired private TypeService		typeService;
	@Autowired private UserService		userService;
	@Autowired private FormService		formService;
	@Autowired private EventService		eventService;
	@Autowired private RouteService		routeService;

	private Logger log = LoggerFactory.getLogger( UsersController.class ); // Log

	/**
	 * Shows public index page
	 * @return String index page
	 */
	@GetMapping( "/" )
	public String index () { return "pages/index"; }

	/**
	 * Shows administration dashboard page
	 * @return String page
	 */
	@GetMapping( "/dashboard" )
	public String dashboard () { return "pages/dashboard"; }

	/**
	 * Shows public pages
	 * @return String public page
	 */
	@GetMapping( "/{page}" )
	public String pages ( @PathVariable String page ) { return "pages/" + page; }

	/**
	 * Handle the contact us form
	 * @param email address of the person to contact
	 * @param name the person name to contact
	 * @param message text to send to the administrator
	 * @return contact us page
	 */
	@PostMapping( "/contactUs" )
	public String contactUs ( @RequestParam String email, @RequestParam String name, @RequestParam String message, RedirectAttributes redirectAttributes )
	{
		Boolean isSent = defaultService.sendEmail( "sistematuristicohdp@gmail.com", "Contacto " + name , name + " " + email + " ha enviado este mensaje: \"" + message + "\"" );
		
		redirectAttributes.addFlashAttribute( "type", isSent ? "success" : "danger" ).addFlashAttribute( "message", "Correo electrónico " + ( isSent ? "" : "no " ) + "enviado" );

		return "redirect:/contactUs"; // Redirects to the contact us page
	}

	/**
	 * Show public form
	 * @return {@link ModelAndView} form with model
	 */
	@GetMapping( "/form" )
	public ModelAndView form ()
	{
		return new ModelAndView( "pages/form/index" )
			.addObject( "locations", locationService.findAll() )
			.addObject( "types", typeService.findAll() )
			.addObject( "genders", Genders.values() )
			.addObject( "form", new Form() )
			.addObject( "user", new User() );
	}

	/**
	 * Save the data from
	 * @param user entity binded
	 * @param form entity binded
	 * @return {@link String} form page
	 */
	@PostMapping( "/form" )
	public String save ( User user, Form form, RedirectAttributes redirectAttributes )
	{
		Long id = 0L;
		String url = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

		// Establish default values
		user.setCreatedAt( new Date() );
		user.setRole( Roles.TURISTA );
		user.setStatus( true );

		try
		{
			form.setUser( userService.simpleSave( user ) ); // Save the user and set the stored data
			id = formService.save( form ).getId(); // Get the id from the saved form

			defaultService.sendEmail( form.getUser().getEmail(), "Sistema Turístico formulario", "Tus resultados están en: " + url + "/form/results/" + id ); // Send an email

			redirectAttributes.addFlashAttribute( "type", "success" ).addFlashAttribute( "message", "Guardado exitoso" ); // Message to be shown once across petitions

			log.info( "Guardado exitoso {}", form );
		}

		catch ( Exception exception )
		{
			// Defines messages to be shown once across petitions
			redirectAttributes.addFlashAttribute( "type", "danger" ).addFlashAttribute( "message", "Guardado erróneo" );
			log.error( "Guardado erróneo: {}", exception );
		}

		return "redirect:/form/results/" + id; // Redirects to results page
	}

	/**
	 * Shows the result of a submited form
	 * @param id entity identifier
	 * @param redirectAttributes flash messages
	 * @return a list of possible routes
	 */
	@GetMapping( "/form/results/{id}" )
	public ModelAndView results ( @PathVariable Long id, RedirectAttributes redirectAttributes )
	{
		ModelAndView mav = new ModelAndView( "/pages/form/results" );

		try
		{
			Form form = formService.findById( id );
			mav.addObject( "routes", routeService.findAllResults( form ) );
			mav.addObject( "form",  form );
		}

		catch ( Exception exception )
		{
			log.error( "Error al buscar entidad: {}", exception.getMessage() );
		}

		return mav;
	}

	/**
	 * Shows all the events
	 * @return all the events
	 */
	@GetMapping( "/public/events" )
	public ModelAndView events ()
	{
		// Initialize an object with a view to be shown and attach model objects with encapsulated data into it to returned
		return new ModelAndView( "pages/events/index" )
			.addObject( "events", eventService.findAllEvents() )
			.addObject( "formatter", new SimpleDateFormat( "dd MMMM yyyy" ) )
			.addObject( "today", new Date() );
	}

	/**
	 * Shows details from an specific event
	 * @param id entity identifier
	 * @return
	 * @throws Exception if entity is not found
	 */
	@GetMapping( "/public/events/{id}" )
	public ModelAndView event ( @PathVariable Long id ) throws Exception
	{
		// Initialize an object with a view to be shown and attach model objects with encapsulated data into it to returned
		return new ModelAndView( "pages/events/details" ).addObject( "event", eventService.findById( id ) ).addObject( "today", new Date() );
	}

	/**
	 * Show routes details
	 * @param id entity identifier
	 * @return
	 * @throws Exception
	 */
	@GetMapping( "/public/routes/{id}" )
	public ModelAndView routes ( @PathVariable Long id ) throws Exception
	{
		// Initialize an object with a view to be shown and attach model objects with encapsulated data into it to returned
		return new ModelAndView( "pages/routes/index" ).addObject( "route", routeService.findById( id ) );
	}
}