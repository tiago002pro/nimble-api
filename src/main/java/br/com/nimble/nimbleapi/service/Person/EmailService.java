package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.Email;
import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.repository.Person.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    EmailRepository repository;

    @Autowired
    PersonService personService;

    public void saveEmail(Long idPerson) {
        Person person = personService.getById(idPerson);
        Email email = new Email();

        email.setEmail("maria@hotmail.com");
        person.getEmails().add(email);
        this.repository.save(email);
    }
}
