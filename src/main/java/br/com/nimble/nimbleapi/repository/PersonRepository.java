package br.com.nimble.nimbleapi.repository;

import br.com.nimble.nimbleapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
