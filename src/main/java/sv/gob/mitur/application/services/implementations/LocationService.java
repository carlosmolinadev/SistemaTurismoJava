package sv.gob.mitur.application.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.gob.mitur.application.entities.Location;
import sv.gob.mitur.application.repositories.ILocationRepository;
import sv.gob.mitur.application.services.interfaces.ILocationService;

/**
 * Concrete class for {@link Location} service
 */
@Service
public class LocationService implements ILocationService
{
	@Autowired private ILocationRepository locationRepository;

	/**
	 * Returns all the entities
	 */
	@Override
	public List<Location> findAll()
	{
		return locationRepository.findAll();
	}
	
	/**
	 * Save an entity
	 * @param travel entity
	 */
	@Override
	public Location save ( Location location )
	{
		return locationRepository.save( location );
	}

	/**
	 * Delete an entity
	 * @param id entity identifier
	 */
	@Override
	public void deleteById ( Long id )
	{
		locationRepository.deleteById( id );
	}

	/**
	 * Find a single entity
	 * @param id entity identifier
	 */
	public Location findById ( Long id ) throws Exception
	{
		return locationRepository.findById( id ).orElseThrow( () -> new Exception( "No se encontr� la ubicaci�n" ) );
	}
}