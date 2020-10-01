package sv.gob.mitur.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.gob.mitur.application.entities.Type;

@Repository
public interface ITypeRepository extends JpaRepository<Type, Long> {
	public List<Type> findByStatusTrue();

}
