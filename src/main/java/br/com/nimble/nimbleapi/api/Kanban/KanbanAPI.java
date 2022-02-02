package br.com.nimble.nimbleapi.api.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Kanban;
import br.com.nimble.nimbleapi.service.Kanban.KanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kanban")
public class KanbanAPI {
    @Autowired
    KanbanService service;

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Kanban> getAllKanbanBoards() {
        return this.service.getAll();
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/id")
    public Kanban getKanbanBoardbyId() {
        return this.service.getById(1L);
    }
}
