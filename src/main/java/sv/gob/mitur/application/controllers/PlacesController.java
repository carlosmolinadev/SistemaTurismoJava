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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.gob.mitur.application.entities.Place;
import sv.gob.mitur.application.services.implementations.LocationService;
import sv.gob.mitur.application.services.implementations.PlaceService;
import sv.gob.mitur.application.services.implementations.RouteService;
import sv.gob.mitur.application.services.implementations.TypeService;

/**
 * Places controller
 */
@Controller
@RequestMapping( "/places" )
public class PlacesController
{
	// Dependency injection
	@Autowired private TypeService		typeService;
	@Autowired private RouteService		routeService;
	@Autowired private LocationService	locationService;
	@Autowired private PlaceService		placeService;

	private Logger log = LoggerFactory.getLogger( PlacesController.class ); // Log
	
	/**
	 * Return a table view with list of entities
	 */
	@GetMapping
	public ModelAndView index ()
	{
		//Initialize an object with a view
		return new ModelAndView( "places/index" )
			.addObject( "places", placeService.findAll() ) // Attach models to the view
			.addObject( "locations", locationService.findAll() )
			.addObject( "types", typeService.findAll() );
	}
	
	/**
	 * It method shows a view by Id from Place
	 * @return a view with a list of data
	 */
	@GetMapping( "/{id}" )
	public ModelAndView show ( @PathVariable Long id ) throws Exception
	{
		// Initialize an object with a view to be shown
		return new ModelAndView( "places/show" )
			.addObject( "formatter", new SimpleDateFormat( "dd MMMM yyyy" ) )
			.addObject( "place", placeService.findById( id ) )
			.addObject( "types", typeService.findAll() )
			.addObject( "routes", routeService.findAll() );
	}
	
	/**
	 * Shows a form view to create an entity
	 * @return the view with a form and lists of resources
	 */
	@GetMapping( "/create" )
	public ModelAndView create ()
	{
		// Initialize an object with a view to be shown
		ModelAndView mav = new ModelAndView( "places/save" );

		// Attach models to the view
		mav.addObject( "formatter", new SimpleDateFormat( "yyyy/MM/dd" ) );
		mav.addObject("place", new Place());
		mav.addObject("types", typeService.findAll());
		mav.addObject("routes", routeService.findAll());
		mav.addObject("locations", locationService.findAll());
		
		return mav;
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
		return new ModelAndView( "places/save" )
			.addObject( "place", placeService.findById( id ) ) // Attach models to the view
			.addObject( "types", typeService.findAll() )
			.addObject( "routes", routeService.findAll() )
			.addObject( "locations", locationService.findAll() );
	}
	
	/**
	 * Process an entity to be saved
	 * @param travel object binded with data from form
	 * @param redirectAttributes encapsulate the messages to send to the view
	 * @return redirects
	 */
	@PostMapping
	public String save ( @RequestParam MultipartFile image, Place place, RedirectAttributes redirectAttributes )
	{
		place.setStatus( true ); // Establish as true its status if is a new entity
		place.setFile( image );
		
		try
		{
			placeService.save( place ); // Save entity

			// Defines messages to be shown once across petitions
			redirectAttributes.addFlashAttribute( "type", "success" ).addFlashAttribute( "message", "Guardado exitoso" );
			log.info( "Guardado exitoso {}", place ); // Log information
		}

		catch ( Exception exception )
		{
			// Defines messages to be shown once across petitions
			redirectAttributes.addFlashAttribute( "type", "danger" ).addFlashAttribute( "message", "Guardado erróneo" );
			log.error( "Guardado erróneo {} {}", exception, place ); // Log error
		}
		
		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "success" ).addFlashAttribute( "message", "Datos guardados" );
		
		return "redirect:/places"; // Redirects to the index of the controller entity
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
		String message = ""; // Message to send to the view

		try
		{
			Place place = placeService.findById( id );	// Retrieve a user from an identifier
			place.setStatus( false );					// Establish as false its status
			placeService.save( place );					// Save the entity

			message = "Eliminación exitosa";
			log.info( message + ": {}", place );		// Log information
		}
		
		catch ( Exception exception )
		{
			message = "Eliminación errónea";
			log.error( message + ": {}", exception );	// Log error
		}
		
		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "danger" ).addFlashAttribute( "message", message );
		
		return "redirect:/places"; // Redirects to the index of the entity controller
	}
}