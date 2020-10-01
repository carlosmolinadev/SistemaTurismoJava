package sv.gob.mitur.application.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.gob.mitur.application.entities.Travel;
import sv.gob.mitur.application.repositories.ITravelRepository;
import sv.gob.mitur.application.services.interfaces.ITravelService;

/**
 * Concrete class for {@link Travel} service
 */
@Service
public class TravelService implements ITravelService
{
	@Autowired private ITravelRepository travelRepository;

	/**
	 * Returns all the entities
	 */
	@Override
	public List<Travel> findAll ()
	{
		return travelRepository.findByStatusTrue();
	}

	/**
	 * Save an entity
	 * @param travel entity
	 */
	@Override
	public Travel save ( Travel travel )
	{
		return travelRepository.save( travel );
	}

	/**
	 * Delete an entity
	 * @param id entity identifier
	 */
	@Override
	public void deleteById ( Long id )
	{
		travelRepository.deleteById( id );
	}

	/**
	 * Find a single entity
	 * @param id entity identifier
	 */
	public Travel findById ( Long id ) throws Exception
	{
		return travelRepository.findById( id ).orElseThrow( () -> new Exception( "No se encontró el viaje" ) );
	}
}