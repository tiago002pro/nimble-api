package br.com.nimble.nimbleapi.service.Kanban;

import br.com.nimble.nimbleapi.repository.Kanban.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    CardRepository repository;
}