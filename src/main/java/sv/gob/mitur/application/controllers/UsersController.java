package sv.gob.mitur.application.controllers;

import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sv.gob.mitur.application.entities.User;
import sv.gob.mitur.application.entities.Roles;
import sv.gob.mitur.application.entities.Genders;
import sv.gob.mitur.application.services.implementations.UserService;
import sv.gob.mitur.application.services.implementations.DefaultService;
import sv.gob.mitur.application.services.implementations.LocationService;

/**
 * Users web controller
 */
@Controller
@RequestMapping( "/users" )
public class UsersController
{
	// Dependencies injection
	@Autowired private UserService				userService;
	@Autowired private LocationService			locationService;
	@Autowired private DefaultService			defaultService;
	@Autowired private BCryptPasswordEncoder	encoder;

	private Logger log = LoggerFactory.getLogger( UsersController.class ); // Log

	/**
	 * Shows a table view with list of entities
	 * @return a view with a list of data
	 */
	@GetMapping
	public ModelAndView index ()
	{
		// Initialize an object with a view to be shown and attach model objects with encapsulated data into it to returned
		return new ModelAndView( "users/index" ).addObject( "users", userService.findAll() ); 
	}

	/**
	 * Shows a table details view of an entity
	 * @param id identifier
	 * @return a view with an entity
	 * @throws Exception
	 */
	@GetMapping( "/{id}" )
	public ModelAndView show ( @PathVariable Long id ) throws Exception
	{
		// Initialize an object with a view to be shown and attach model objects with encapsulated data into it to returned
		return new ModelAndView( "users/show" ).addObject( "user", userService.findById( id ) );
	}

	/**
	 * Shows a form view to create an entity
	 * @return the view with a form and lists of resources
	 */
	@GetMapping( "/create" )
	public ModelAndView create ()
	{
		// Initialize an object with a view to be shown and returns the object with encapsulated data
		return new ModelAndView( "users/save" )
			.addObject( "user", new User() )	// Attach models to the view
			.addObject( "genders", Genders.values() )
			.addObject( "roles", Roles.values() )
			.addObject( "locations", locationService.findAll() );
	}

	/**
	 * Shows a form view to edit an entity
	 * @param id entity identifier
	 * @return the view with a form and lists of resources
	 */
	@GetMapping( "/{id}/edit" )
	public ModelAndView edit ( @PathVariable Long id ) throws Exception
	{
		// Initialize an object with a view to be shown and returns the object with encapsulated data
		return new ModelAndView( "users/save" )
			.addObject( "genders", Genders.values() ) // Attach models to the view
			.addObject( "roles", Roles.values() )
			.addObject( "locations", locationService.findAll() )
			.addObject( "user", userService.findById( id ) );
	}

	/**
	 * Process an entity to be saved
	 * @param user object binded with data from form
	 * @param redirectAttributes encapsulate the messages to send to the view
	 * @return a redirection to a controller
	 */
	@PostMapping
	public String save ( User user, @RequestParam MultipartFile profile, RedirectAttributes redirectAttributes )
	{
		Boolean isNew = user.getId() == null && user.getStatus() == null;
		String pass = user.getPassword();

		user.setStatus( true ); // Establish as true its status if is a new entity
		user.setFile( profile );
		user.setPassword( isNew ? encoder.encode( pass ) : null );

		try
		{
			userService.save( user ).getEmail();

			if ( isNew )
			{
				String url = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
				
				defaultService.sendEmail( user.getEmail(), "Sistema Turístico", "Se ha creado una cuenta en nuestro sistema como " + user.getRole() + ". Puede iniciar sesión en " + url + "/login con las credenciales\nUsuario: " + user.getEmail() + "\nContraseña: " + pass );
			}

			// Defines messages to be shown once across petitions
			redirectAttributes.addFlashAttribute( "type", "success" ).addFlashAttribute( "message", "Guardado exitoso" );
			log.info( "Guardado exitoso {}", user ); // Log information
		}

		catch ( Exception exception )
		{
			// Defines messages to be shown once across petitions
			redirectAttributes.addFlashAttribute( "type", "danger" ).addFlashAttribute( "message", "Guardado erróneo" );
			log.error( "Guardado erróneo {} {}", exception, user ); // Log error
		}

		return "redirect:/users"; // Redirects to the index of the controller entity
	}

	/**
	 * Deletes an entity by its id
	 * @param id entity identifier
	 * @param redirectAttributes encapsulate the messages to send to the view
	 * @return a redirection to a controller
	 */
	@GetMapping( "/{id}/delete" )
	public String destroy ( @PathVariable Long id, RedirectAttributes redirectAttributes )
	{
		String message = ""; // Message to send to the view

		try
		{
			User user = userService.findById( id );		// Retrieve a user from an identifier
			user.setStatus( false );					// Establish as false its status
			userService.save( user );					// Save the entity

			message = "Eliminación exitosa";
			log.info( message + ": {}", user );			// Log information
		}
		
		catch ( Exception exception )
		{
			message = "Eliminación errónea";
			log.error( message + ": {}", exception );	// Log error
		}

		// Defines messages to be shown once across petitions
		redirectAttributes.addFlashAttribute( "type", "danger" ).addFlashAttribute( "message", message );
		
		return "redirect:/users"; // Redirects to the index of the entity controller
	}
}