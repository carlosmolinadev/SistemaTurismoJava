package sv.gob.mitur.application.services.interfaces;

import java.util.List;
import sv.gob.mitur.application.entities.Form;
import sv.gob.mitur.application.entities.Route;

public interface IRouteService 
{
	public List<Route> findAll ();

	public List<Route> findAllResults ( Form form );
	
	public Route save ( Route route );
	
	public void deleteById ( Long id );
	
	public Route findById( Long id ) throws Exception;
}