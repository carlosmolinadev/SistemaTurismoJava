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
import sv.gob.mitur.application.entities.Location;
import sv.gob.mitur.application.services.implementations.LocationService;
import sv.gob.mitur.application.services.implementations.PlaceService;
import sv.gob.mitur.application.services.implementations.RegionService;
import sv.gob.mitur.application.services.implementations.UserService;




/**
 * Travels web controller
 */
@Controller
@RequestMapping("/locations")
public class LocationsController {
	// Services injection
	@Autowired private LocationService	locationService;
	@Autowired private RegionService	regionService;
	@Autowired private UserService		userService;
	@Autowired private PlaceService		placeService;

	private Logger log = LoggerFactory.getLogger( Controller.class );
	/**
	 * Shows a table view with list of entities
	 * @return a view with a list of data
	 */
	@GetMapping
	public ModelAndView index ()
	{
		// Initialize an object with a view to be shown attach models to the view and returns the object with encapsulated data
		return new ModelAndView( "locations/index" ).addObject( "locations", locationService.findAll() );
	}
	
	@GetMapping( "/{id}" )
	public ModelAndView show ( @PathVariable Long id ) throws Exception
	{
		// Initialize an object with a view to be shown attach models to the view and returns the object with encapsulated data
		return new ModelAndView( "locations/show" ).addObject( "location", locationService.findById( id ) );
	}
	
	/**
	 * Shows a form view to create an entity
	 * @return the view with a form and lists of resources
	 */
	@GetMapping( "/create" )
	public ModelAndView create ()
	{
		// Initialize an object with a view to be shown attach models to the view and returns the object with encapsulated data
		return new ModelAndView( "locations/save" )
			.addObject( "location", new Location( ) )
			.addObject( "regions", regionService.findAll() );
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
		ModelAndView mav = new ModelAndView( "locations/save" );

		// Attach models to the view
		mav.addObject( "formatter", new SimpleDateFormat( "yyyy/MM/dd" ) )
			.addObject( "location", locationService.findById( id ) )
			.addObject("users", userService.findAll())
			.addObject("places", placeService.findAll())
			.addObject( "regions", regionService.findAll());
			

		return mav; // Returns the object with encapsulated data
	}
	
	/**
	 * Process an entity to be saved
	 * @param travel object binded with data from form
	 * @param redirectAttributes encapsulate the messages to send to the view
	 * @return redirects
	 */
	@PostMapping
	public String save ( Location location, RedirectAttributes redirectAttributes )
	{
		// Establish as true its status if is a new entity if not 
		location.setStatus( true );
		
		locationService.save(location); // Saves the entity

		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "success" ).addFlashAttribute( "message", "Ubicación guardada exitosamente" );
		log.info( "Guardado exitoso {}", location );
		
		return "redirect:/locations"; // Redirects to the index of the controller entity
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
			Location location = locationService.findById( id );
			location.setStatus( false );
			locationService.save( location );
			message = "Eliminación exitosa";
			log.info( message + " {}", location );
		}
		
		catch ( Exception e ) {
			message = "Eliminación errónea";
			log.error( message + " {}", e );
		}

		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "danger" ).addFlashAttribute( "message", message );
		
		return "redirect:/locations"; // Redirects to the index of the entity controller
	}
}