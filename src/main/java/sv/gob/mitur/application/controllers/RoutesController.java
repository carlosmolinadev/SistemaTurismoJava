package sv.gob.mitur.application.controllers;

import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sv.gob.mitur.application.entities.Route;
import sv.gob.mitur.application.services.implementations.LocationService;
import sv.gob.mitur.application.services.implementations.RouteService;
import sv.gob.mitur.application.services.implementations.TravelService;
import sv.gob.mitur.application.services.implementations.TypeService;
import sv.gob.mitur.application.services.implementations.UserService;

/**
 * Routes web controller
 */
@Controller
@RequestMapping( "/routes" )
public class RoutesController
{
	// Services injection
	@Autowired private TravelService	travelService;
	@Autowired private RouteService		routeService;
	@Autowired private LocationService	locationService;
	@Autowired private UserService 		userService;
	@Autowired private TypeService 		typeService;

	private Logger log = LoggerFactory.getLogger( Controller.class );

	/**
	 * Shows a table view with list of entities
	 * @return a view with a list of data
	 */
	@GetMapping
	public ModelAndView index ()
	{
		// Initialize an object with a view to be shown
		ModelAndView mav = new ModelAndView( "routes/index" );

		// Attach models to the view
		mav.addObject( "formatter", new SimpleDateFormat( "dd MMMM yyyy" ) );
		mav.addObject( "locations", locationService.findAll() );
		mav.addObject( "routes", routeService.findAll() );
		mav.addObject( "travels", travelService.findAll() );
		
		return mav; // Returns the object with encapsulated data
	}
	
	/**
	 * Shows a table according to route id
	 * @return a view with an specific id
	 */
	@GetMapping( "/{id}" )
	public ModelAndView show ( @PathVariable Long id ) throws Exception
	{
		// Initialize an object with a view to be shown, attach models to the view and returns the object with encapsulated data
		return new ModelAndView( "routes/show" ).addObject( "route", routeService.findById( id ) );
	}
	
	/**
	 * Shows a form view to create an entity
	 * @return the view with a form and lists of resources
	 */
	@GetMapping( "/create" )
	public ModelAndView create ()
	{
		// Initialize an object with a view to be shown, attach models to the view and returns the object with encapsulated data
		return new ModelAndView( "routes/save" )
			.addObject( "route", new Route() )
			.addObject( "routes", routeService.findAll() )
			.addObject( "location", locationService.findAll() )
			.addObject( "users", userService.findAllGuides() )
			.addObject( "types", typeService.findAll() );
	}

	/**
	 * Save an entity
	 * @param route
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping
	public String save ( Route route, RedirectAttributes redirectAttributes )
	{
		route.setStatus( true ); // Establish as true its status if is a new entity
		
		routeService.save( route ); // Saves the entity

		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "success" ).addFlashAttribute( "message", "Ruta guardado exitosamente" );
		log.info( "Guardado exitoso {}", route );
		
		return "redirect:/routes"; // Redirects to the index of the controller entity
	}

	/**
	 * Retrieve an entity to edit it
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping( "/{id}/edit" )
	public ModelAndView edit ( @PathVariable Long id ) throws Exception
	{
		// Initialize an object with a view to be shown, attach models to the view and returns the object with encapsulated data
		return new ModelAndView( "routes/save" )
			.addObject( "route", new Route() )
			.addObject( "route", routeService.findById( id ) )
			.addObject( "location", locationService.findAll() )
			.addObject( "users", userService.findAll() )
			.addObject( "types", typeService.findAll() );
	}
	
	/**
	 * Deletes an entity by its id
	 * @param id entity identifier
	 * @param redirectAttributes encapsulate the messages to send to the view
	 * @return redirects
	 */
	@GetMapping( "/{id}/delete" )
	public String destroy ( @PathVariable Long id, RedirectAttributes redirectAttributes )
	{
		String message = "";

		try
		{
			Route route = routeService.findById( id );
			route.setStatus( false );
			routeService.save( route );
			message = "Eliminación exitosa";
			log.info( message + " {}", route );
		}
		
		catch ( Exception e ) {
			message = "Eliminación errónea";
			log.error( message + " {}", e );
		}

		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "danger" ).addFlashAttribute( "message", message );
		
		return "redirect:/routes"; // Redirects to the index of the entity controller
	}
}