package br.com.nimble.nimbleapi.service.Finance;

import br.com.nimble.nimbleapi.model.Finance.Title;
import br.com.nimble.nimbleapi.repository.Finance.TitleRepository;
import br.com.nimble.nimbleapi.service.Person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TitleService {
    @Autowired
    TitleRepository repository;
    @Autowired
    PersonService personService;

    public List<Title> createTitle(List<Title>  resource) {
        resource.forEach((title) -> {
            title.setPerson(this.personService.getById(title.getPerson().getId()));
        });
        return this.repository.saveAll(resource);
    }

    public Page<Title>  getTitlesByType(String type, Pageable pageable) {
        return this.repository.findTitlesByType(type, pageable);
    }
}
