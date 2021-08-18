package br.com.nimble.nimbleapi.service.KanbanBoardService;

import br.com.nimble.nimbleapi.model.KanbanBoard.ListCards;
import br.com.nimble.nimbleapi.repository.KanbanBoardRepository.ListCardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ListCardsService {

    @Autowired
    ListCardsRepository repository;

    public String createListCards(Map<String, Object> json) {
        ListCards listCards = new ListCards();
        listCards.setTitle((String) json.get("Título"));
        this.repository.save(listCards);
        return "Lista Gerada com sucesso!";
    }

    public List<ListCards> getAllListCards() {
        return this.repository.findAll();
    }

    public ListCards getListCardById(Long id) {
        return this.repository.findById(id).get();
    }
}
