package br.com.nimble.nimbleapi.repository.Person;

import br.com.nimble.nimbleapi.model.Person.Individual;
import br.com.nimble.nimbleapi.model.Person.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(nativeQuery = true,
            value = " SELECT p.*" +
                    " FROM person p" +
                    " left JOIN rule r ON r.person_id = p.id" +
                    " WHERE r.rule = :rule")
    List<Person> findAllPersonByRule(@Param("rule") String rule);

    @Query(nativeQuery = true,
            value = " SELECT *" +
                    " FROM person ")
    List<Person> findAllPerson();
}
