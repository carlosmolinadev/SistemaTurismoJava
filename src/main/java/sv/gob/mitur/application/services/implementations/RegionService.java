package sv.gob.mitur.application.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.gob.mitur.application.entities.Region;
import sv.gob.mitur.application.repositories.IRegionRepository;
import sv.gob.mitur.application.services.interfaces.IRegionService;

/**
 * Concrete class for {@link Region} service
 */
@Service
public class RegionService implements IRegionService
{
	@Autowired private IRegionRepository regionRepository;
	
	/**
	 * Returns all the entities
	 */
	@Override
	public List<Region> findAll ()
	{
		return regionRepository.findAll();
	}

	/**
	 * Find a single entity
	 * @param id entity identifier
	 */
	@Override
	public Region findById ( Long id ) throws Exception
	{
		return regionRepository.findById( id ).orElseThrow( () -> new Exception( "No se encontró el viaje" ) );
	}
}