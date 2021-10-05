package br.com.nimble.nimbleapi.repository.Person;

import br.com.nimble.nimbleapi.model.Person.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Long> {}
