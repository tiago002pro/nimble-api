package br.com.nimble.nimbleapi.service.KanbanBoardService;

import br.com.nimble.nimbleapi.model.KanbanBoard.Card;
import br.com.nimble.nimbleapi.model.KanbanBoard.ListCards;
import br.com.nimble.nimbleapi.repository.KanbanBoardRepository.CardRepository;
import br.com.nimble.nimbleapi.repository.KanbanBoardRepository.ListCardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CardService {

    @Autowired
    CardRepository repository;
    @Autowired
    ListCardsService listCardsService;

    public String createCards(Long id_listCard, Map<String, Object> json) {
        ListCards listCards = listCardsService.getListCardById(id_listCard);
        Card card = new Card();
        card.setTitle((String) json.get("Título"));
        card.setDescription((String) json.get("Descrição"));
        listCards.getCards().add(card);
        this.repository.save(card);
        return "Cartão Gerado com sucesso!";
    }

    public List<Card> findAllCards() {
        return this.repository.findAll();
    }
}
