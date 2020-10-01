package sv.gob.mitur.application.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sv.gob.mitur.application.entities.Event;
import sv.gob.mitur.application.repositories.IEventRepository;
import sv.gob.mitur.application.services.interfaces.IEventService;

/**
 * Concrete class for {@link Event} service
 */
@Service
public class EventService implements IEventService
{
	@Autowired private IEventRepository eventRepository;
	
	/**
	 * Returns all the entities
	 */
	@Override
	public List<Event> findAll () 
	{
		return eventRepository.findByStatusTrue();
	}

	@Override
	public List<Event> findAllEvents ()
	{
		return eventRepository.findAll( Sort.by( Sort.Direction.DESC, "startDate" ) );
	}

	/**
	 * Save an entity
	 * @param event entity
	 */
	@Override
	public Event save ( Event event )
	{
		return eventRepository.save( event );
	}

	@Override
	public void deleteById ( Long id )
	{
		eventRepository.deleteById( id );
	}

	@Override
	public Event findById ( Long id ) throws Exception
	{
		return eventRepository.findById( id ).orElseThrow( () -> new Exception( "No se encontro el evento" ) );
	}
}