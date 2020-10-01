package sv.gob.mitur.application.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.gob.mitur.application.entities.Form;
import sv.gob.mitur.application.repositories.IFormRepository;
import sv.gob.mitur.application.services.interfaces.IFormService;

@Service
public class FormService implements IFormService
{
	@Autowired private IFormRepository formRepository;

	@Override
	public Form save ( Form form )
	{
		return formRepository.save( form );
	}

	@Override
	public Form findById ( Long id ) throws Exception
	{
		return formRepository.findById( id ).orElseThrow( () -> new Exception( "No se encontró el formulario" ) );
	}
}