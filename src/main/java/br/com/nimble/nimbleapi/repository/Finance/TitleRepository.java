package br.com.nimble.nimbleapi.repository.Finance;

import br.com.nimble.nimbleapi.model.Finance.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {
    @Query(nativeQuery = true,
            value = " SELECT " +
                    "   * " +
                    " FROM title t " +
                    " WHERE t.type = :type " +
                    " ORDER BY t.duo_date ")
    Page<Title> findTitlesByType(@Param("type") String type, Pageable pageable);

    @Query(nativeQuery = true,
            value = " SELECT " +
                    "   * " +
                    " FROM title t " +
                    " WHERE t.account_id = :accountId ")
    Page<Title> findTitlesByAccountId(@Param("accountId") Long accountId, Pageable pageable);
}