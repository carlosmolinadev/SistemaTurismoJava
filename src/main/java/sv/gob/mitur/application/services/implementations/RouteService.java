package sv.gob.mitur.application.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.gob.mitur.application.entities.Form;
import sv.gob.mitur.application.entities.Route;
import sv.gob.mitur.application.repositories.IRouteRepository;
import sv.gob.mitur.application.services.interfaces.IRouteService;

/**
 * Concrete class for {@link Route} service
 */
@Service
public class RouteService implements IRouteService
{
	@Autowired private IRouteRepository routeRepository;

	/**
	 * Returns all the entities
	 */
	@Override
	public List<Route> findAll ()
	{
		return routeRepository.findByStatusTrue();
	}

	@Override
	public List<Route> findAllResults ( Form form )
	{
		Double amount	= form.getBudget() / form.getPersons();
		Double duration	= Double.valueOf( form.getDuration() );
		return routeRepository.findByStatusTrueAndImporteLessThanEqualAndDurationLessThanEqual( amount, duration );
	}
	
	/**
	 * Save an entity
	 * @param route entity
	 */
	@Override
	public Route save ( Route route )
	{
		return routeRepository.save( route );
	}
	
	/**
	 * Delete an entity
	 * @param id entity identifier
	 */
	@Override
	public void deleteById ( Long id )
	{
		routeRepository.deleteById( id );
	}
	
	/**
	 * Find a single entity
	 * @param id entity identifier
	 */
	public Route findById ( Long id ) throws Exception
	{
		return routeRepository.findById( id ).orElseThrow( () -> new Exception( "No se encontró la ruta" ) );
	}
}