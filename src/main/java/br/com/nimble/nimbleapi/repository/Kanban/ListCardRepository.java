package br.com.nimble.nimbleapi.repository.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.ListCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ListCardRepository extends JpaRepository<ListCard, Long> {
    @Query(nativeQuery = true,
    value = " SELECT " +
            "   * " +
            " FROM list_card lc " +
            " WHERE lc.index_list = :index ")
    ListCard findListCardByIndex(@Param("index") Long index);
}