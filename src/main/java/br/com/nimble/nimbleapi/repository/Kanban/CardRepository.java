package br.com.nimble.nimbleapi.repository.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {}