package sv.gob.mitur.application.services.interfaces;

import java.util.List;

import sv.gob.mitur.application.entities.User;

public interface IUserService
{
	public List<User> findAll ();
	
	public List<User> findAllGuides ();

	public User simpleSave ( User user );

	public User save ( User user ) throws Exception;

	public User findById ( Long id ) throws Exception;
}