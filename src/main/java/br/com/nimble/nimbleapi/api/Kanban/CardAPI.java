package br.com.nimble.nimbleapi.api.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Card;
import br.com.nimble.nimbleapi.model.Kanban.ListCard;
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
    @RequestMapping(method = RequestMethod.POST, value = "/listCard/{index}/new")
    public ListCard newCard(@PathVariable Long index,
                            @RequestBody String cardTitle) {
        return this.service.newCard(Long.valueOf(index), cardTitle);
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Card> getAllCards() {
        return this.service.getAllCards();
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
    public Card changeIndexCard(@RequestParam(value = "previous") Integer previousIndex, @RequestBody Integer currentIndex) {
        return this.service.changeIndexCard(Long.valueOf(previousIndex), Long.valueOf(currentIndex));
    }
}