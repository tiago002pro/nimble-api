package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.Email;
import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.repository.Person.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailService {

    @Autowired
    EmailRepository repository;

    @Autowired
    PersonService personService;

    public void saveEmail(Long idPerson, Map<String, String> json) {
        Person person = personService.getById(idPerson);
        Email email = new Email(
                json.get("email")
        );

        person.getEmails().add(email);
        this.repository.save(email);
    }
}
