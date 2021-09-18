package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.Address;
import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.repository.Person.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    @Autowired
    PersonService personService;

    public void saveAddress(Long idPerson, Map<String, String> json) {
        Person person = personService.getById(idPerson);

        Address address = new Address(
                json.get("zipCode"),
                json.get("premisse"),
                json.get("number"),
                json.get("neighbourhood"),
                json.get("information"),
                json.get("location"),
                json.get("state"),
                json.get("country")
        );

        person.getAddresses().add(address);
        this.repository.save(address);
    }
}
