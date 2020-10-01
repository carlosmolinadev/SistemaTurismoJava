package sv.gob.mitur.application.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.gob.mitur.application.entities.Type;
import sv.gob.mitur.application.repositories.ITypeRepository;
import sv.gob.mitur.application.services.interfaces.ITypeService;

/**
 * Concrete class for {@Link Type} services
 */
@Service
public class TypeService implements ITypeService
{
	@Autowired private ITypeRepository typeRepository;
	
	/**
	 * Return all enable entities
	 */
	@Override
	public List<Type> findAll ()
	{
		return typeRepository.findByStatusTrue();
	}
	
	/**
	 * This method save an entity
	 */
	@Override
	public Type save ( Type type ) 
	{
		return typeRepository.save( type );
	}
	
	/**
	 * Find a record by ID
	 */
	@Override
	public Type findById ( Long id ) throws Exception
	{
		return typeRepository.findById( id ).orElseThrow( () -> new Exception( "No se encontró el type" ) );
	}
}