package br.com.nimble.nimbleapi.service.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Card;
import br.com.nimble.nimbleapi.model.Kanban.ListCard;
import br.com.nimble.nimbleapi.repository.Kanban.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository repository;
    @Autowired
    ListCardService listCardService;

    public Card newCard() {
        Card card = new Card();
        ListCard listCard = this.listCardService.getById(1L);
        card.setTitle("Teste");
//        listCard.getCardList().add(card);
        this.repository.save(card);
        return card;
    }

    public Card changeIdlistCard(Long listCardId, Long cardId) {
        Card card = this.getById(cardId);
        ListCard listCard = this.listCardService.getById(listCardId);
        card.setListCard(listCard);
        this.repository.save(card);
        return card;
    }

    public List<Card> getAllCards() {
        return this.repository.findAll();
    }

    public Card getById(Long id) {
        return this.repository.findById(id).get();
    }

    public List<Card> getCardByListCardId(Long id) {
        return this.repository.findCardByListCardId(id);
    }

    public Card getCardByIndex(Long index) {
        return this.repository.findCardByIndex(index);
    }

    public Card changeIndexCard(Card card, Long index) {
        List<Card> cardListForChange = new ArrayList<>();
        if (index < card.getIndexCard()) {
            for(long x = index; x < card.getIndexCard(); x ++) {
                Card cardChange = this.getCardByIndex(x);
                cardListForChange.add(cardChange);
            }
            cardListForChange.stream().forEach(item -> item.setIndexCard(item.getIndexCard() + 1L));
        } else {
            for(long x = card.getIndexCard() + 1L; x <= index; x ++) {
                Card cardChange = this.getCardByIndex(x);
                cardListForChange.add(cardChange);
            }
            cardListForChange.stream().forEach(item -> item.setIndexCard(item.getIndexCard() - 1L));
        }

        this.repository.saveAll(cardListForChange);
        card.setIndexCard(index);
        this.repository.save(card);
        return card;
    }
}