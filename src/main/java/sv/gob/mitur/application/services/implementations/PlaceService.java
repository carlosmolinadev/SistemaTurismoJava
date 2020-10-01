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
import org.springframework.stereotype.Service;
import sv.gob.mitur.application.configuration.S3;
import sv.gob.mitur.application.entities.Place;
import sv.gob.mitur.application.repositories.IPlaceRepository;
import sv.gob.mitur.application.services.interfaces.IPlaceService;

/**
 *Concrete class for {@link Place} service
 */
@Service
public class PlaceService implements IPlaceService
{
	@Autowired private IPlaceRepository placeRepository; // Dependency injection

	private S3 s3; // S3 server configuration

	/**
	 * Service constructor
	 * @param s3
	 */
	public PlaceService ( S3 s3 )
	{
		this.s3 = s3;
	}

	/**
	 * return all the entities
	 */
	@Override
	public List<Place> findAll ()
	{
		return placeRepository.findAll();
	}

	/**
	 * Save an entity
	 */
	@Override
	public Place save ( Place place ) throws Exception
	{
		String relativePath	= "images/places/" + UUID.randomUUID() + place.getFile().getOriginalFilename();

		AWSCredentials credentials = new BasicAWSCredentials( s3.getAccessKeyId(), s3.getSecretAccessKey() );
		
		AmazonS3 s3client = AmazonS3ClientBuilder
			.standard()
			.withCredentials( new AWSStaticCredentialsProvider( credentials ) )
			.withRegion( Regions.US_EAST_2 )
			.build();

		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentLength( place.getFile().getSize() );
		objectMetadata.setLastModified( new Date() );

		s3client.putObject( s3.getBucket(), relativePath, place.getFile().getInputStream(), objectMetadata );

		place.setPhoto( relativePath );
		
		return placeRepository.save( place );
	}

	/**
	 * Delete an entity
	 */
	@Override
	public void deleteById ( Long id )
	{
		placeRepository.deleteById( id );
	}

	/**
	 * Find a single entity
	 */
	@Override
	public Place findById ( Long id )
	{
		return placeRepository.findById( id ).orElse( new Place() );
	}
}