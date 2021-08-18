package br.com.nimble.nimbleapi.api.KanbanBoardAPI;

import br.com.nimble.nimbleapi.model.KanbanBoard.Card;
import br.com.nimble.nimbleapi.model.KanbanBoard.ListCards;
import br.com.nimble.nimbleapi.service.KanbanBoardService.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/card")
public class CardApi {

    @Autowired
    CardService service;

    @CrossOrigin
    @RequestMapping(path = {"/post/{id_listCard}"}, method = {RequestMethod.POST})
    public String createCards(@PathVariable Long id_listCard, @RequestBody Map<String, Object> json) {
        return this.service.createCards(id_listCard, json);
    }

    @CrossOrigin
    @Transactional(readOnly = true)
    @RequestMapping("/get")
    public List<Card> getAllCards() {
        return this.service.findAllCards();
    }
}
