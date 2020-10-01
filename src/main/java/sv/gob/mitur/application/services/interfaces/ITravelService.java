package sv.gob.mitur.application.services.interfaces;

import java.util.List;

import sv.gob.mitur.application.entities.Travel;

public interface ITravelService
{
	public List<Travel> findAll ();

	public Travel save ( Travel travel );

	public void deleteById ( Long id );
	
	public Travel findById ( Long id ) throws Exception;
}