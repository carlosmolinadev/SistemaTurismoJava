package sv.gob.mitur.application.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorsController implements ErrorController
{
	@Override
	public String getErrorPath ()
	{
		return "/error";
	}

	@RequestMapping( "/error" )
	public ModelAndView handleError ( HttpServletRequest request )
	{
		ModelAndView mav = new ModelAndView( "error" );
		Object status = request.getAttribute( RequestDispatcher.ERROR_STATUS_CODE ); // Get error status

		if ( status != null )
		{
			Integer statusCode = Integer.parseInt( status.toString() );

			// Display specific error page
			if ( statusCode == HttpStatus.NOT_FOUND.value() )
			{
				mav.addObject( "code", 404 ).addObject( "message",  "Recurso no encontrado" );
			}
			
			else if ( statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value() )
			{
				mav.addObject( "code", 500 ).addObject( "message",  "Error interno de servidor" );
			}
			
			else if ( statusCode == HttpStatus.FORBIDDEN.value() )
			{
				mav.addObject( "code", 403 ).addObject( "message",  "Prohibido" );
			}
			
			else
			{
				mav.addObject( "code" , "Error" ).addObject( "message", "Error inesperado" );
			}
		}

		return mav;
	}
}