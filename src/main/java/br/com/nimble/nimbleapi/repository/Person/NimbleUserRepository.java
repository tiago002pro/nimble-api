package br.com.nimble.nimbleapi.repository.Person;

import br.com.nimble.nimbleapi.model.Person.NimbleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NimbleUserRepository extends JpaRepository<NimbleUser, Long> {
    NimbleUser findByUsername(String username);
}
