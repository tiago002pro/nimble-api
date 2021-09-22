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

    public Individual createPF(Individual resource) {
        this.repository.save(resource);
        return resource;
    }

    public List<Individual> getLisPF() {
        return this.repository.findAll();
    }
}
