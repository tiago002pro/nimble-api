package br.com.nimble.nimbleapi.repository.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Kanban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KanbanRepository extends JpaRepository<Kanban, Long> {}