package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.*;
import br.com.nimble.nimbleapi.repository.Person.JuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class JuridicaService {

    @Autowired
    JuridicaRepository repository;

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

    public Juridica createPJ(Juridica resource) {
         this.repository.save(resource);
         return resource;
    }

    public List<Juridica> getLisPJ() {
        return this.repository.findAll();
    }
}
