package br.com.nimble.nimbleapi.api.Kanban;

import br.com.nimble.nimbleapi.model.Kanban.Card;
import br.com.nimble.nimbleapi.service.Kanban.ListCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@RestController
@RequestMapping(name = "/api/listCard")
public class ListCardAPI {
    @Autowired
    ListCardService service;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_card_id")
    private List<Card> cardList;
}