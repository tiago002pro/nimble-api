package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.*;
import br.com.nimble.nimbleapi.repository.Person.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class IndividualService {

    @Autowired
    IndividualRepository repository;

    @Autowired
    AddressService addressService;

    @Autowired
    PhoneService phoneService;

    @Autowired
    EmailService emailService;

    @Autowired
    DocumentService documentService;

    @Autowired
    RuleService ruleService;

    public Individual createPF(Map<String, String> json) {
        List<Address> addresses = new ArrayList<>();
        List<Phone> phones = new ArrayList<>();
        List<Email> emails = new ArrayList<>();
        List<Document> documents = new ArrayList<>();
        List<Rule> ruleList = new ArrayList<>();

        Individual individual = new Individual(
                json.get("name"),
                addresses,
                phones,
                emails,
                documents,
                ruleList,
                json.get("cpf"),
                json.get("rg"),
                json.get("gender")
        );

        this.repository.save(individual);
        this.addressService.saveAddress(individual.getId(), json);
        this.phoneService.savePhone(individual.getId(), json);
        this.emailService.saveEmail(individual.getId(), json);
        this.documentService.saveDocument(individual.getId(), json);
        this.ruleService.saveRule(individual.getId(), json);

        return individual;
    }

    public List<Individual> getLisPF() {
        return this.repository.findAll();
    }
}
