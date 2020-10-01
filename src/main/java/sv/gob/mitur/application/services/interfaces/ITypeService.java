package sv.gob.mitur.application.services.interfaces;

import java.util.List;
import sv.gob.mitur.application.entities.Type;

public interface ITypeService 
{
	public List<Type> findAll ();

	public Type save ( Type type );

	public Type findById ( Long id ) throws Exception;
}