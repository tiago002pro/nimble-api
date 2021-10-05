package br.com.nimble.nimbleapi.repository.Person;

import br.com.nimble.nimbleapi.model.Person.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(nativeQuery = true,
            value = "select" +
                    " p.id," +
                    " p.name," +
                    " p.dateofbirthorfondation," +
                    " i.cpf," +
                    " j.cnpj" +
                    " from" +
                    " person p" +
                    " left join individual i on i.person_id = p.id" +
                    " left join juridica j on j.person_id = p.id" +
                    " left join rule r on r.person_id = p.id" +
                    " where r.rule = :rule")
    Page<Map<String, Object>> findAllPersonByRule(@Param("rule") String rule, Pageable pageable);
}
