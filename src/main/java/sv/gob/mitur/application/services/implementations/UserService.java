package sv.gob.mitur.application.services.implementations;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sv.gob.mitur.application.configuration.S3;
import sv.gob.mitur.application.entities.Roles;
import sv.gob.mitur.application.entities.User;
import sv.gob.mitur.application.repositories.IUserRepository;
import sv.gob.mitur.application.services.interfaces.IUserService;

/**
 * Concrete class for {@link User} service
 */
@Service
public class UserService implements IUserService, UserDetailsService
{
	@Autowired private IUserRepository userRepository; // Dependency injection

	private S3 s3; // S3 server configuration

	/**
	 * Service constructor
	 * @param s3
	 */
	public UserService ( S3 s3 )
	{
		this.s3 = s3;
	}

	/**
	 * Returns all enable entities
	 */
	@Override
	public List<User> findAll ()
	{
		return userRepository.findByStatusTrue();
	}

	@Override
	public List<User> findAllGuides ()
	{
		return userRepository.findByRoleAndStatusTrue( Roles.GUIA );
	}

	/**
	 * Save without an image
	 * @param user entity to save
	 */
	@Override
	public User simpleSave ( User user )
	{
		return userRepository.save( user );
	}

	/**
	 * Save an entity
	 * @param user entity to save
	 */
	@Override
	public User save ( User user ) throws Exception
	{
		String relativePath	= "images/users/" + UUID.randomUUID() + user.getFile().getOriginalFilename();

		AWSCredentials credentials = new BasicAWSCredentials( s3.getAccessKeyId(), s3.getSecretAccessKey() );
		
		AmazonS3 s3client = AmazonS3ClientBuilder
			.standard()
			.withCredentials( new AWSStaticCredentialsProvider( credentials ) )
			.withRegion( Regions.US_EAST_2 )
			.build();

		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentLength( user.getFile().getSize() );
		objectMetadata.setLastModified( new Date() );

		s3client.putObject( s3.getBucket(), relativePath, user.getFile().getInputStream(), objectMetadata );

		user.setPhoto( relativePath );

		return userRepository.save( user );
	}

	/**
	 * Find a single entity
	 * @param id entity identifier
	 */
	@Override
	public User findById ( Long id ) throws Exception
	{
		return userRepository.findById( id ).orElseThrow( () -> new Exception( "No se encontró el usuario" ) );
	}

	/**
	 * Find a single entity by its username
	 * @param username unique user name
	 */
	@Override
	public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException
	{
		return userRepository.findByEmail( username )
			.orElseThrow( () -> new UsernameNotFoundException( "No se encontró el nombre de usuario: " + username ) );
	}
}