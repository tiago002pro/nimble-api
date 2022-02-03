package br.com.nimble.nimbleapi.repository.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.ListCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListCardRepository extends JpaRepository<ListCard, Long> {

    @Query(nativeQuery = true,
    value = " SELECT " +
            "   * " +
            " FROM list_card lc " +
            " WHERE lc.index_list = :index ")
    ListCard findListCardByIndex(@Param("index") Long index);

    @Query(nativeQuery = true,
            value = " SELECT " +
                    "   * " +
                    " FROM list_card lc " +
                    " WHERE lc.name = :name ")
    ListCard findListCardByName(@Param("name") String name);

    @Query(nativeQuery = true, value = "SELECT * FROM list_card lc ORDER BY lc.index_list")
    List<ListCard> findAllListCardOrderByIndex();

    @Query(nativeQuery = true, value = "SELECT lc.index_list FROM list_card lc ORDER BY lc.index_list DESC limit 1")
    Long findLastListIndex();
}