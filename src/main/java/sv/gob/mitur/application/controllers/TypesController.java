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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sv.gob.mitur.application.entities.Type;
import sv.gob.mitur.application.services.implementations.PlaceService;
import sv.gob.mitur.application.services.implementations.RouteService;
import sv.gob.mitur.application.services.implementations.TypeService;

/**
 * 
 * Type controller
 *
 */
@Controller
@RequestMapping ("/types")
public class TypesController {
	//Dependencies injection
	@Autowired private TypeService typeService;
	@Autowired private RouteService routeService;
	@Autowired private PlaceService placeService;
	
	private Logger log = LoggerFactory.getLogger( TypesController.class );
	
	/**
	 * This method shows the entity's content
	 */
	@GetMapping
	public ModelAndView index()
	{
		// Initialize an object with a view to be shown
		ModelAndView mav = new ModelAndView("types/index");
		
		// it get the data, then attach data to the view
		mav.addObject("types", typeService.findAll());
		
		return mav;
	}
	
	/**
	 * return a table details view of an entity
	 */
	@GetMapping( "/{id}" )
	public ModelAndView show ( @PathVariable Long id ) throws Exception
	{
		//Initialize the object
		ModelAndView mav = new ModelAndView("types/show");
		
		// it get the data, then attach data to the view
		mav.addObject("type", typeService.findById(id))
		.addObject("routes", routeService.findAll())
		.addObject("places", placeService.findAll());
		
		return mav; // Returns the object with encapsulated data
	}
	
	/**
	 * return the resources to create an entity
	 */
	@GetMapping( "/create" )
	public ModelAndView create()
	{
		//Initialize a new object to be shown
		ModelAndView mav = new ModelAndView("types/save");
		
		//Attach models to the view
		mav.addObject( "formatter", new SimpleDateFormat( "yyyy/MM/dd" ) );
		mav.addObject("type", new Type());
		
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
		//Initialize a new object to be shown
		ModelAndView mav = new ModelAndView("types/save");
		
		mav.addObject("formatter", new SimpleDateFormat( "yyyy/MM/dd" ));
		mav.addObject("type", typeService.findById(id));
		
		return mav;
		
	}
	
	/**
	 * Process an entity to be saved
	 * @param redirectAttributes encapsulate the messages to send to the view
	 * @return redirects
	 */
	@PostMapping
	public String save ( Type type, RedirectAttributes redirectAttributes)
	{
		//It verify if is a new entity
		type.setStatus(true);
		type.setCreatedAt(new Date());
		
		//This command saves the entity
		typeService.save(type);
		
		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "success" ).addFlashAttribute( "message", "Informacion guardada" );
		
		return "redirect:/types"; // Redirects to the index of the controller entity
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
		
		try {
			Type type = typeService.findById(id);
			type.setStatus(false);
			typeService.save(type);
			message = "Eliminación exitosa";
			log.info( message + " {}", type );
			
		} catch (Exception e) {
			message = "No se pudo eliminar la informacion";
			log.error( message + " {}", e );
		}
		
		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "danger" ).addFlashAttribute( "message", message );
				
		return "redirect:/types"; // Redirects to the index of the entity controller
	}
}
