package sv.gob.mitur.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.gob.mitur.application.entities.Form;

public interface IFormRepository extends JpaRepository<Form, Long> {}