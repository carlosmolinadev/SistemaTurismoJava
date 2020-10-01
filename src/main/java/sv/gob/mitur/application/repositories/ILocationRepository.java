package sv.gob.mitur.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.gob.mitur.application.entities.Location;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Long> {
	
	public List<Location> findByStatusTrue();
}