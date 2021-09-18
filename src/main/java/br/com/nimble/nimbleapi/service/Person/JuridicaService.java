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

    public Juridica createPJ(Map<String, String> json) {
        List<Address> addresses = new ArrayList<>();
        List<Phone> phones = new ArrayList<>();
        List<Email> emails = new ArrayList<>();
        List<Document> documents = new ArrayList<>();
        List<Rule> ruleList = new ArrayList<>();

        Juridica juridica = new Juridica(
                json.get("name"),
                addresses,
                phones,
                emails,
                documents,
                ruleList,
                json.get("short_name"),
                json.get("cnpj"),
                json.get("ie")
        );

        this.repository.save(juridica);
        this.addressService.saveAddress(juridica.getId(), json);
        this.phoneService.savePhone(juridica.getId(), json);
        this.emailService.saveEmail(juridica.getId(), json);
        this.documentService.saveDocument(juridica.getId(), json);
        this.ruleService.saveRule(juridica.getId(), json);

        return juridica;
    }

    public List<Juridica> getLisPJ() {
        return this.repository.findAll();
    }
}
