package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.model.Person.Phone;
import br.com.nimble.nimbleapi.model.Person.Rule;
import br.com.nimble.nimbleapi.repository.Person.PhoneRepository;
import br.com.nimble.nimbleapi.repository.Person.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PhoneService {

    @Autowired
    PhoneRepository repository;

    @Autowired
    PersonService personService;

    public void savePhone(Long idPerson, Map<String, String> json) {
        Person person = personService.getById(idPerson);
        Phone phone = new Phone(
                json.get("phone"),
                json.get("phoneType")
        );

        person.getPhones().add(phone);
        this.repository.save(phone);
    }
}
