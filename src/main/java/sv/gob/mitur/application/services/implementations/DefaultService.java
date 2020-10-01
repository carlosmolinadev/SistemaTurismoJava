package sv.gob.mitur.application.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import sv.gob.mitur.application.configuration.Email;
import sv.gob.mitur.application.services.interfaces.IDefaultService;

@Service
public class DefaultService implements IDefaultService
{
	private Email email;
	private Logger log = LoggerFactory.getLogger( DefaultService.class ); // Log

	/**
	 * Service constructor
	 * @param email
	 */
	public DefaultService ( Email email )
	{
		this.email = email;
	}

	/**
	 * Send an email from a template
	 * @param to email address
	 * @param subject resume
	 * @param text body message
	 * @return wether success or not
	 */
	@Override
	public Boolean sendEmail ( String to, String subject, String text )
	{
		JavaMailSenderImpl sender = new JavaMailSenderImpl(); // Generates a sender
		sender.setHost( this.email.getHost() );
		sender.setPort( this.email.getPort() );
		sender.setUsername( this.email.getUsername() );
		sender.setPassword( this.email.getPassword() );

		sender.getJavaMailProperties().put( "mail.smtp.starttls.enable", "true" ); // Enable TLS

		SimpleMailMessage mailMessage = new SimpleMailMessage(); // Generates a message to be send
		mailMessage.setFrom( this.email.getUsername() );
		mailMessage.setTo( to );
		mailMessage.setSubject( subject );
		mailMessage.setText( text );

		try
		{
			sender.send( mailMessage ); // Send the message
			log.info( "Correo electrónico enviado con éxito: {}", sender.toString() ); return true;
		}

		catch ( Exception exception )
		{
			log.error( "Error al enviar correo electrónico: {}", exception.getMessage() ); return false;
		}
	}
}