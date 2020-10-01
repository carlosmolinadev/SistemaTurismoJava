package sv.gob.mitur.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.gob.mitur.application.entities.Travel;

@Repository
public interface ITravelRepository extends JpaRepository <Travel, Long> {

	public List<Travel> findByStatusTrue();
	
}
