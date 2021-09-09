package br.com.nimble.nimbleapi.repository.Person;

import br.com.nimble.nimbleapi.model.Person.Juridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JuridicaRepository extends JpaRepository<Juridica, Long> {
}
