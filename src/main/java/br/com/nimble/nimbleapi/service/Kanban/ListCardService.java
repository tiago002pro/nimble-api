package br.com.nimble.nimbleapi.service.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Card;
import br.com.nimble.nimbleapi.model.Kanban.ListCard;
import br.com.nimble.nimbleapi.repository.Kanban.ListCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListCardService {
    @Autowired
    ListCardRepository repository;

    public ListCard getById(Long id) {
        return this.repository.findById(id).get();
    }

    public List<ListCard> getAllListCards() {
        return this.repository.findAll();
    }

    public ListCard getListCardByIndex(Long index) {
        return this.repository.findListCardByIndex(index);
    }

    public ListCard changeIndexListCard(ListCard listCard, Long index) {
        List<ListCard> listCardListForChange = new ArrayList<>();
        if (index < listCard.getIndexList()) {
            for(long x = index; x < listCard.getIndexList(); x ++) {
                ListCard listCardChange = this.getListCardByIndex(x);
                listCardListForChange.add(listCardChange);
            }
            listCardListForChange.stream().forEach(item -> item.setIndexList(item.getIndexList() + 1L));
        } else {
            for(long x = listCard.getIndexList() + 1L; x <= index; x ++) {
                ListCard listCardChange = this.getListCardByIndex(x);
                listCardListForChange.add(listCardChange);
            }
            listCardListForChange.stream().forEach(item -> item.setIndexList(item.getIndexList() - 1L));
        }

        this.repository.saveAll(listCardListForChange);
        listCard.setIndexList(index);
        this.repository.save(listCard);
        return listCard;
    }
}