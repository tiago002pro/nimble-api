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

    public String createPJ(Map<String, String> json) {
        List<Address> addresses = new ArrayList<>();
        List<Phone> phones = new ArrayList<>();
        List<Email> emails = new ArrayList<>();
        List<Document> documents = new ArrayList<>();
        List<Rule> ruleList = new ArrayList<>();

        Juridica juridica = new Juridica(
                "Maria",
                addresses,
                phones,
                emails,
                documents,
                ruleList,
                "Maria LTDA",
                "123456789",
                "45678912"
        );

        this.repository.save(juridica);
        this.addressService.saveAddress(juridica.getId());
        this.phoneService.savePhone(juridica.getId());
        this.emailService.saveEmail(juridica.getId());
        this.documentService.saveDocument(juridica.getId());
        this.ruleService.saveRule(juridica.getId());
        return "Pessoa Juridica cadastrada com sucesso";
    }

    public List<Juridica> getLisPJ() {
        return this.repository.findAll();
    }
}
