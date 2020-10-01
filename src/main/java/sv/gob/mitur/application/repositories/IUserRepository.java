package sv.gob.mitur.application.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.gob.mitur.application.entities.Roles;
import sv.gob.mitur.application.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>
{
	public List<User> findByStatusTrue();

	public List<User> findByRoleAndStatusTrue( Roles role );

	public Optional<User> findByEmail( String email );
}