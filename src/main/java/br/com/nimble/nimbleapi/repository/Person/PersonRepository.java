package br.com.nimble.nimbleapi.repository.Person;

import br.com.nimble.nimbleapi.model.Person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(nativeQuery = true,
            value = "SELECT p.* " +
                    "FROM person p " +
                    "   INNER JOIN rule r ON p.id = r.person_id " +
                    "WHERE r.rule = :rule")
    List<Person> findAllPersonByRule(@Param("rule") String rule);
}
