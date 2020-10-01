package sv.gob.mitur.application.services.interfaces;

import java.util.List;
import sv.gob.mitur.application.entities.Region;

public interface IRegionService
{
	public List<Region> findAll ();
	
	public Region findById ( Long id ) throws Exception;
}