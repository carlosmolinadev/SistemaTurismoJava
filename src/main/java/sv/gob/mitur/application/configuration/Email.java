package sv.gob.mitur.application.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Email
{
	@Value( "${spring.mail.host}")
	private String host;

	@Value( "${spring.mail.username}" )
	private String username;

	@Value( "${spring.mail.password}" )
	private String password;

	@Value( "${spring.mail.port}" )
	private Integer port;

	public String getHost ()
	{
		return host;
	}

	public void setHost ( String host )
	{
		this.host = host;
	}

	public String getUsername ()
	{
		return username;
	}

	public void setUsername ( String username )
	{
		this.username = username;
	}

	public String getPassword ()
	{
		return password;
	}

	public void setPassword ( String password )
	{
		this.password = password;
	}

	public Integer getPort ()
	{
		return port;
	}

	public void setPort ( Integer port )
	{
		this.port = port;
	}
}