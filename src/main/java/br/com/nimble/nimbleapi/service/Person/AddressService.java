package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.Address;
import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.repository.Person.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    @Autowired
    PersonService personService;

    public void saveAddress(Long idPerson) {
        Person person = personService.getById(idPerson);
        Address address = new Address();

        address.setZipCode("87013-100");
        address.setPremisseType("Rua");
        address.setPremisse("Piratininga");
        address.setNumber("119");
        address.setNeighbourhood("Zona 1");
        address.setInformation("Endereço comercial");
        address.setLocation("Maringá");
        address.setState("PR");
        address.setCountry("Brasil");
        person.getAddresses().add(address);
        this.repository.save(address);
    }
}
