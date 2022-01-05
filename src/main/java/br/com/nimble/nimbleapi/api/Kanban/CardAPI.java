package br.com.nimble.nimbleapi.api.Kanban;

import br.com.nimble.nimbleapi.service.Kanban.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api/card")
public class CardAPI {
    @Autowired
    private CardService service;
}