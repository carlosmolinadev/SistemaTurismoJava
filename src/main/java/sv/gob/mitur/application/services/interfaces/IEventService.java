package sv.gob.mitur.application.services.interfaces;

import java.util.List;

import sv.gob.mitur.application.entities.Event;

public interface IEventService
{
	public List<Event> findAll ();

	public List<Event> findAllEvents ();
	
	public Event save ( Event event );
	
	public void deleteById ( Long id );
	
	public Event findById ( Long id ) throws Exception;
}