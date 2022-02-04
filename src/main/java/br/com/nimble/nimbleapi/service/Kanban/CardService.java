package br.com.nimble.nimbleapi.service.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Board;
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
    @Autowired
    BoardService boardService;

    public ListCard newCard(Long indexList, String cardTitle) {
        ListCard listCard = this.listCardService.getListCardByIndex(indexList);
        Card card = new Card();
        card.setTitle(cardTitle);
        card.setIndexCard(this.getLastIndexCard(indexList) + 1L);
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

    public Card getCardByIndex(Long indexCard, Long indexList) {
        return this.repository.findCardByIndex(indexCard, indexList);
    }

    public ListCard changeIndexCard(Long previousIndex, Long currentIndex, Long indexList) {
        Card card = this.getCardByIndex(previousIndex, indexList);

        List<Card> cardListForChange = new ArrayList<>();
        if (currentIndex < card.getIndexCard()) {
            for(long x = currentIndex; x < card.getIndexCard(); x ++) {
                Card cardChange = this.getCardByIndex(x, indexList);
                cardListForChange.add(cardChange);
            }
            cardListForChange.stream().forEach(item -> item.setIndexCard(item.getIndexCard() + 1L));
        } else {
            for(long x = card.getIndexCard() + 1L; x <= currentIndex; x ++) {
                Card cardChange = this.getCardByIndex(x, indexList);
                cardListForChange.add(cardChange);
            }
            cardListForChange.stream().forEach(item -> item.setIndexCard(item.getIndexCard() - 1L));
        }

        this.repository.saveAll(cardListForChange);
        card.setIndexCard(currentIndex);
        this.repository.save(card);

        return this.listCardService.getListCardByIndex(indexList);
    }

    public Long getLastIndexCard(Long indexList) {
        Long lastIndex = this.repository.findLastIndexCard(indexList);
        if (lastIndex == null) {
            return 0L;
        } else {
            return lastIndex;
        }
    }

    public List<ListCard> movCardBetweenLists(String nameListPrevious, String nameListCurrent, Long indexCardPrevious, Long indexCardCurrent) {
        ListCard listCardPrevious = this.listCardService.getListCardByName(nameListPrevious);
        ListCard listCardCurrent = this.listCardService.getListCardByName(nameListCurrent);
        Card card = this.getCardByIndex(indexCardPrevious, listCardPrevious.getIndexList());
        List<Card> cardListToSave = new ArrayList<>();

        for (long x = indexCardPrevious + 1L; x <= this.getLastIndexCard(listCardPrevious.getIndexList()); x++) {
            this.repository.flush();
            Card cardChange = this.getCardByIndex(x, listCardPrevious.getIndexList());
            cardChange.setIndexCard(x - 1L);
            cardListToSave.add(cardChange);
        }

        for (long x = this.getLastIndexCard(listCardCurrent.getIndexList()); x >= indexCardCurrent; x--) {
                Card cardChange = this.getCardByIndex(x, listCardCurrent.getIndexList());
                cardChange.setIndexCard(x + 1L);
                cardListToSave.add(cardChange);
            }

        this.repository.saveAll(cardListToSave);
        card.setIndexCard(indexCardCurrent);
        listCardCurrent.getCardList().add(card);
        this.repository.save(card);

        return this.listCardService.getListCardOrderByIndexAsc();
    }
}