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
                    " WHERE c.index_card = :indexCard" +
                    "   AND c.list_card_id = :indexList")
    Card findCardByIndex(@Param("indexCard") Long indexCard, @Param("indexList") Long indexList);

    @Query(nativeQuery = true,
            value = " SELECT " +
                    "   c.index_card " +
                    " FROM card c " +
                    " WHERE c.list_card_id = :indexList" +
                    " ORDER BY " +
                    "   c.index_card " +
                    " DESC LIMIT 1")
    Long findLastIndexCard(@Param("indexList") Long indexList);
}