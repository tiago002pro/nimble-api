package br.com.nimble.nimbleapi.service.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Board;
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

    @Autowired
    BoardService boardService;

    public ListCard getById(Long id) {
        return this.repository.findById(id).get();
    }

    public List<ListCard> getAllListCards() {
        return this.repository.findAll();
    }

    public List<ListCard> getListCardOrderByIndexAsc() {
        return this.repository.findAllListCardOrderByIndex();
    }

    public ListCard getListCardByIndex(Long index) {
        return this.repository.findListCardByIndex(index);
    }

    public ListCard changeIndexListCard(Long previousIndex, Long currentIndex) {
       ListCard listCard = this.getListCardByIndex(previousIndex);

        List<ListCard> listCardListForChange = new ArrayList<>();
        if (currentIndex < listCard.getIndexList()) {
            for(long x = currentIndex; x < listCard.getIndexList(); x ++) {
                ListCard listCardChange = this.getListCardByIndex(x);
                listCardListForChange.add(listCardChange);
            }
            listCardListForChange.stream().forEach(item -> item.setIndexList(item.getIndexList() + 1L));
        } else {
            for(long x = listCard.getIndexList() + 1L; x <= currentIndex; x ++) {
                ListCard listCardChange = this.getListCardByIndex(x);
                listCardListForChange.add(listCardChange);
            }
            listCardListForChange.stream().forEach(item -> item.setIndexList(item.getIndexList() - 1L));
        }

        this.repository.saveAll(listCardListForChange);
        listCard.setIndexList(currentIndex);
        this.repository.save(listCard);
        return listCard;
    }

     public ListCard newCard(String nameList) {
        ListCard listCard = new ListCard();
         Board board = this.boardService.getBoardById(1L);

        listCard.setName(nameList);
        listCard.setIndexList(this.repository.findLastListIndex() + 1L);
        board.getListCardList().add(listCard);
        this.repository.save(listCard);
        return listCard;
    }
}