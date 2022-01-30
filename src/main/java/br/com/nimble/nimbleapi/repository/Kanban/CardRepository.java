package br.com.nimble.nimbleapi.repository.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query(nativeQuery = true,
            value = " SELECT " +
                    "   * " +
                    " FROM card c " +
                    " WHERE c.list_card_id = :idListCard")
    List<Card> findCardByListCardId(@Param("idListCard") Long idListCard);

    @Query(nativeQuery = true,
            value = " SELECT " +
                    "   * " +
                    " FROM card c " +
                    " WHERE c.index_card = :index")
    Card findCardByIndex(@Param("index") Long index);
}