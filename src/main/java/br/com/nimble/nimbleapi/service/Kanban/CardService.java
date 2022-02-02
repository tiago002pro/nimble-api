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

    public ListCard newCard(Long indexList, String cardTitle) {
        ListCard listCard = this.listCardService.getListCardByIndex(indexList);
        Card card = new Card();
        card.setTitle(cardTitle);
        card.setIndexCard(this.getLastIndexCard() + 1L);
        listCard.getCardList().add(card);
        this.repository.save(card);
        return listCard;
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

    public Card changeIndexCard(Long previousIndex, Long currentIndex) {
        Card card = this.getCardByIndex(previousIndex);

        List<Card> cardListForChange = new ArrayList<>();
        if (currentIndex < card.getIndexCard()) {
            for(long x = currentIndex; x < card.getIndexCard(); x ++) {
                Card cardChange = this.getCardByIndex(x);
                cardListForChange.add(cardChange);
            }
            cardListForChange.stream().forEach(item -> item.setIndexCard(item.getIndexCard() + 1L));
        } else {
            for(long x = card.getIndexCard() + 1L; x <= currentIndex; x ++) {
                Card cardChange = this.getCardByIndex(x);
                cardListForChange.add(cardChange);
            }
            cardListForChange.stream().forEach(item -> item.setIndexCard(item.getIndexCard() - 1L));
        }

        this.repository.saveAll(cardListForChange);
        card.setIndexCard(currentIndex);
        this.repository.save(card);
        return card;
    }

    public Long getLastIndexCard() {
        return this.repository.findLastIndexCard();
    }
}