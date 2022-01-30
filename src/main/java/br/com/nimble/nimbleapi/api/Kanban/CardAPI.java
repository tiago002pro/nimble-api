package br.com.nimble.nimbleapi.api.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Card;
import br.com.nimble.nimbleapi.service.Kanban.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardAPI {
    @Autowired
    private CardService service;

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public Card newCard() {
        return this.service.newCard();
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Card> getAllCards() {
        return this.service.getAllCards();
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.PUT, value = "/change")
    public Card changeIdlistCard() {
        return this.service.changeIdlistCard(2L, 3L);
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/listCard")
    public List<Card> getCardByListCardId() {
        return this.service.getCardByListCardId(2L);
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.PUT, value = "/change-index-card")
    public Card changeIndexCard(@RequestBody Card card, @RequestParam(value = "index") Long index) {
        return this.service.changeIndexCard(card, index);
    }
}