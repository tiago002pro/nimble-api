package br.com.nimble.nimbleapi.repository.KanbanBoardRepository;

import br.com.nimble.nimbleapi.model.KanbanBoard.ListCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListCardsRepository extends JpaRepository<ListCards, Long> {
}
