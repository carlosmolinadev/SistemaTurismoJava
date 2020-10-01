package sv.gob.mitur.application.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class S3
{
	@Value( "${aws.s3.bucket}" )
	private String bucket;

	@Value( "${aws.s3.username}" )
	private String username;

	@Value( "${aws.s3.access-key-id}" )
	private String accessKeyId;

	@Value( "${aws.s3.secret-access-key}" )
	private String secretAccessKey;

	@Value( "${aws.s3.url}" )
	private static String url;

	public String getBucket ()
	{
		return bucket;
	}

	public void setBucket ( String bucket )
	{
		this.bucket = bucket;
	}

	public String getUsername ()
	{
		return username;
	}

	public void setUsername ( String username )
	{
		this.username = username;
	}

	public String getAccessKeyId ()
	{
		return accessKeyId;
	}

	public void setAccessKeyId ( String accessKeyId )
	{
		this.accessKeyId = accessKeyId;
	}

	public String getSecretAccessKey ()
	{
		return secretAccessKey;
	}

	public void setSecretAccessKey ( String secretAccessKey )
	{
		this.secretAccessKey = secretAccessKey;
	}

	public static String getUrl ()
	{
		return url;
	}
}