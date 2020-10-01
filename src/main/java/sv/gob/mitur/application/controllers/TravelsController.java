package sv.gob.mitur.application.controllers;

import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.gob.mitur.application.entities.Travel;
import sv.gob.mitur.application.services.implementations.RouteService;
import sv.gob.mitur.application.services.implementations.TravelService;
import sv.gob.mitur.application.services.implementations.UserService;


/**
 * Travels web controller
 */
@Controller
@RequestMapping("/travels")
public class TravelsController {
	// Services injection
	@Autowired private TravelService	travelService;
	@Autowired private UserService		userService;
	@Autowired private RouteService		routeService;

	private Logger log = LoggerFactory.getLogger( Controller.class );
	/**
	 * Shows a table view with list of entities
	 * @return a view with a list of data
	 */
	@GetMapping
	public ModelAndView index ()
	{
		// Initialize an object with a view to be shown
		ModelAndView mav = new ModelAndView( "travels/index" );

		// Attach models to the view
		mav.addObject( "formatter", new SimpleDateFormat( "dd MMMM yyyy" ) );
		mav.addObject( "travels", travelService.findAll() );
		
		return mav; // Returns the object with encapsulated data
	}
	
	@GetMapping( "/{id}" )
	public ModelAndView show ( @PathVariable Long id ) throws Exception
	{
		// Initialize an object with a view to be shown
		ModelAndView mav = new ModelAndView( "travels/show" );

		// Attach models to the view
		mav.addObject( "formatter", new SimpleDateFormat( "dd MMMM yyyy" ) );
		mav.addObject( "travel", travelService.findById( id ) )
		.addObject("routes", routeService.findAll());

		return mav; // Returns the object with encapsulated data
	}
	
	/**
	 * Shows a form view to create an entity
	 * @return the view with a form and lists of resources
	 */
	@GetMapping( "/create" )
	public ModelAndView create ()
	{
		// Initialize an object with a view to be shown
		ModelAndView mav = new ModelAndView( "travels/save" );

		// Attach models to the view
		mav.addObject( "travel", new Travel() )
		.addObject( "users", userService.findAll())
		.addObject( "routes", routeService.findAll());

		return mav; // Returns the object with encapsulated data
	}
	
	/**
	 * Shows a form view to edit an entity
	 * @param id entity identifier
	 * @return the view with a form and lists of resources
	*/
	@GetMapping( "/{id}/edit" )
	public ModelAndView edit ( @PathVariable Long id ) throws Exception
	{
		// Initialize an object with a view to be shown
		ModelAndView mav = new ModelAndView( "travels/save" );

		// Attach models to the view
		mav.addObject( "formatter", new SimpleDateFormat( "yyyy/MM/dd" ) );
		mav.addObject( "travel", travelService.findById( id ) )
			.addObject( "users", userService.findAll())
			.addObject( "routes", routeService.findAll());

		return mav; // Returns the object with encapsulated data
	}
	
	/**
	 * Process an entity to be saved
	 * @param travel object binded with data from form
	 * @param redirectAttributes encapsulate the messages to send to the view
	 * @return redirects
	 */
	@PostMapping
	public String save ( Travel travel, RedirectAttributes redirectAttributes )
	{
		
		// Establish as true its status if is a new entity if not 
		travel.setStatus( true );
		
		travelService.save( travel ); // Saves the entity

		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "success" ).addFlashAttribute( "message", "Viaje guardado exitosamente" );
		log.info( "Guardado exitoso {}", travel );
		
		return "redirect:/travels"; // Redirects to the index of the controller entity
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
			Travel travel = travelService.findById( id );
			travel.setStatus( false );
			travelService.save( travel );
			message = "Eliminación exitosa";
			log.info( message + " {}", travel );
		}
		
		catch ( Exception e ) {
			message = "Eliminación errónea";
			log.error( message + " {}", e );
		}

		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "danger" ).addFlashAttribute( "message", message );
		
		return "redirect:/travels"; // Redirects to the index of the entity controller
	}
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
