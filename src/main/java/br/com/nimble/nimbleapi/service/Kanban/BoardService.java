package br.com.nimble.nimbleapi.service.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Board;
import br.com.nimble.nimbleapi.repository.Kanban.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardRepository repository;

    public List<Board> getAll() {
        return this.repository.findAll();
    }
}
