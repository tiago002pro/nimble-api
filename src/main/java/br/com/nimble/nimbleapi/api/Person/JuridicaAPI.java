package br.com.nimble.nimbleapi.api.Person;

import br.com.nimble.nimbleapi.model.Person.Juridica;
import br.com.nimble.nimbleapi.service.Person.JuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/person-juridica")
public class JuridicaAPI {

    @Autowired
    JuridicaService service;

    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/form")
    public Juridica setJuridicalPerson(@RequestBody Map<String, String> json)  {
        return this.service.createPJ(json);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public List<Juridica> getJuridicalPerson() {
        return this.service.getLisPJ();
    }
}
