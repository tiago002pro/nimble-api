package br.com.nimble.nimbleapi.api.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Card;
import br.com.nimble.nimbleapi.model.Kanban.ListCard;
import br.com.nimble.nimbleapi.service.Kanban.ListCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listCard")
public class ListCardAPI {
    @Autowired
    ListCardService service;

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<ListCard> getAllListCards() {
        return this.service.getAllListCards();
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/id")
    public ListCard getListCardById() {
        return this.service.getById(1L);
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.PUT, value = "/change-index-list")
    public ListCard changeIndexListCard(@RequestBody ListCard listCard, @RequestParam(value = "index") Long index) {
        return this.service.changeIndexListCard(listCard, index);
    }
}