package br.com.nimble.nimbleapi.repository.Person;

import br.com.nimble.nimbleapi.model.Person.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true,
            value = " SELECT" +
                    " CASE" +
                    " WHEN EXISTS(" +
                    " SELECT * FROM user_ u" +
                    " WHERE u.login = :login AND u.password = :password)" +
                    " THEN cast(1 AS bit)" +
                    " ELSE cast(0 AS bit)" +
                    " END")
    Boolean validateLogin(@Param("login") String login, @Param("password") String password);
}
