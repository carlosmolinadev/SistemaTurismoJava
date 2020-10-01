package sv.gob.mitur.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.gob.mitur.application.entities.Region;

@Repository
public interface IRegionRepository extends JpaRepository <Region, Long> {}