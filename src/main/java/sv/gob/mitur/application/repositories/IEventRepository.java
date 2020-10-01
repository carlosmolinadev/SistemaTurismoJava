package sv.gob.mitur.application.repositories;

import org.springframework.stereotype.Repository;
import sv.gob.mitur.application.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface IEventRepository extends JpaRepository <Event, Long>
{
	public List<Event> findByStatusTrue();
}