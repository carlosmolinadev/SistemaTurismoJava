package sv.gob.mitur.application.services.interfaces;

import java.util.List;
import sv.gob.mitur.application.entities.Location;

public interface ILocationService
{
	public List<Location> findAll ();

	public Location save ( Location location );

	public void deleteById ( Long id );
	
	public Location findById ( Long id ) throws Exception;
}