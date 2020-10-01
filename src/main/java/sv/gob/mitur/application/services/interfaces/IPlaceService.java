package sv.gob.mitur.application.services.interfaces;

import java.util.List;

import sv.gob.mitur.application.entities.Place;

public interface IPlaceService
{
	public List<Place> findAll ();

	public Place save ( Place place ) throws Exception;

	public void deleteById ( Long id );
	
	public Place findById ( Long id );
}