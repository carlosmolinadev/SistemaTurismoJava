package sv.gob.mitur.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.mitur.application.entities.Place;

@Repository
public interface IPlaceRepository extends JpaRepository<Place, Long> {

}
