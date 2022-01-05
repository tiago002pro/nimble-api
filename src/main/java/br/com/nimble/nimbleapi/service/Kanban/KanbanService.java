package br.com.nimble.nimbleapi.service.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Kanban;
import br.com.nimble.nimbleapi.repository.Kanban.KanbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KanbanService {
    @Autowired
    KanbanRepository repository;

    public Kanban getById(Long id) {
        return this.repository.findById(id).get();
    }

    public List<Kanban> getAll() {
        return this.repository.findAll();
    }
}