package sv.gob.mitur.application.services.interfaces;

import sv.gob.mitur.application.entities.Form;

public interface IFormService
{
	public Form save ( Form form );

	public Form findById( Long id ) throws Exception;
}