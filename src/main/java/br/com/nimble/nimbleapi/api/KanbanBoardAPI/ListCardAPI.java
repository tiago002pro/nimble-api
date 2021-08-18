package br.com.nimble.nimbleapi.api.KanbanBoardAPI;

import br.com.nimble.nimbleapi.model.KanbanBoard.Card;
import br.com.nimble.nimbleapi.model.KanbanBoard.ListCards;
import br.com.nimble.nimbleapi.service.KanbanBoardService.CardService;
import br.com.nimble.nimbleapi.service.KanbanBoardService.ListCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ListCards")
public class ListCardAPI {

    @Autowired
    ListCardsService service;

    @RequestMapping(path = {"/post"}, method = {RequestMethod.POST})
    public String createListCards(@RequestBody Map<String, Object> json) {
        return this.service.createListCards(json);
    }

    @RequestMapping(path = {"/get"}, method = {RequestMethod.GET})
    public List<ListCards> getAllListCards() {
        return this.service.getAllListCards();
    }
}