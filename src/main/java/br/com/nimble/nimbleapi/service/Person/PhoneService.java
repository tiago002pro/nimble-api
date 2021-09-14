package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.model.Person.Phone;
import br.com.nimble.nimbleapi.model.Person.Rule;
import br.com.nimble.nimbleapi.repository.Person.PhoneRepository;
import br.com.nimble.nimbleapi.repository.Person.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    @Autowired
    PhoneRepository repository;

    @Autowired
    PersonService personService;

    public void savePhone(Long idPerson) {
        Person person = personService.getById(idPerson);
        Phone phone = new Phone();

        phone.setPhone("4432218550");
        phone.setPhoneType("Comercial");
        person.getPhones().add(phone);
        this.repository.save(phone);
    }
}
