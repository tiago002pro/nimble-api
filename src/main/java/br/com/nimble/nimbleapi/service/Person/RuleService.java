package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.Email;
import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.model.Person.Rule;
import br.com.nimble.nimbleapi.repository.Person.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    @Autowired
    RuleRepository repository;

    @Autowired
    PersonService personService;

    public void saveRule(Long idPerson) {
        Person person = personService.getById(idPerson);
        Rule rule = new Rule();

        rule.setRule("Fornecedor");
        rule.setTag("FORNECEDOR");
        person.getRuleList().add(rule);
        this.repository.save(rule);
    }
}
