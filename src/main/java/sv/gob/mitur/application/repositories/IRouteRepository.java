package sv.gob.mitur.application.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.gob.mitur.application.entities.Route;

@Repository
public interface IRouteRepository extends JpaRepository<Route, Long>
{
	public List<Route> findByStatusTrue ();

	public List<Route> findByStatusTrueAndImporteLessThanEqualAndDurationLessThanEqual( Double importe, Double duration );
}