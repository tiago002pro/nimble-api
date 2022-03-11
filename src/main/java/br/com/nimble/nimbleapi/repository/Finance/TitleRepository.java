package br.com.nimble.nimbleapi.repository.Finance;

import br.com.nimble.nimbleapi.model.Finance.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM title t WHERE t.type = :type")
    List<Title> findTitlesByType(@Param("type") String type);
}
