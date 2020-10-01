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
import sv.gob.mitur.application.entities.Event;
import sv.gob.mitur.application.services.implementations.EventService;
import sv.gob.mitur.application.services.implementations.PlaceService;

/**
 * Events web controller
 */
@Controller
@RequestMapping("/events")
public class EventsController {
	// Services injection
	@Autowired private EventService	eventService;
	@Autowired private PlaceService	placeService;
	
	private Logger log = LoggerFactory.getLogger( Controller.class );
	
	@GetMapping
	public ModelAndView index ()
	{
		// Initialize an object with a view to be shown
		ModelAndView mav = new ModelAndView( "events/index" );

		// Attach models to the view
		mav.addObject( "formatter", new SimpleDateFormat( "dd MMMM yyyy" ) );
		mav.addObject( "events", eventService.findAll() )
			.addObject( "places", placeService.findAll() );
		
		return mav; // Returns the object with encapsulated data
	}
	
	@GetMapping( "/{id}" )
	public ModelAndView show ( @PathVariable Long id ) throws Exception
	{
		// Initialize an object with a view to be shown
		ModelAndView mav = new ModelAndView( "events/show" );

		// Attach models to the view
		mav.addObject( "formatter", new SimpleDateFormat( "dd MMMM yyyy" ) );
		mav.addObject( "event", eventService.findById( id ) )
		.addObject("places", placeService.findAll());

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
		ModelAndView mav = new ModelAndView( "events/save" );

		// Attach models to the view
		mav.addObject( "event", new Event() )
		.addObject( "places", placeService.findAll());

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
		ModelAndView mav = new ModelAndView( "events/save" );

		// Attach models to the view
		mav.addObject( "formatter", new SimpleDateFormat( "yyyy/MM/dd" ) );
		mav.addObject( "event", eventService.findById( id ) )
			.addObject( "places", placeService.findAll());

		return mav; // Returns the object with encapsulated data
	}
	
	/**
	 * Process an entity to be saved
	 * @param event object binded with data from form
	 * @param redirectAttributes encapsulate the messages to send to the view
	 * @return redirects
	 */
	@PostMapping
	public String save ( Event event, RedirectAttributes redirectAttributes )
	{
		
		// Establish as true its status if is a new entity if not 
		event.setStatus( true );
		
		eventService.save( event ); // Saves the entity

		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "success" ).addFlashAttribute( "message", "Viaje guardado exitosamente" );
		log.info( "Guardado exitoso {}", event );
		
		return "redirect:/events"; // Redirects to the index of the controller entity
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
			Event event = eventService.findById( id );
			event.setStatus( false );
			eventService.save( event );
			message = "Eliminación exitosa";
			log.info( message + " {}", event );
		}
		
		catch ( Exception exception )
		{
			message = "Eliminación errónea";
			log.error( message + " {}", exception );
		}

		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "danger" ).addFlashAttribute( "message", message );
		
		return "redirect:/events"; // Redirects to the index of the entity controller
	}
}