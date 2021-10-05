package br.com.nimble.nimbleapi.api.Person;

import br.com.nimble.nimbleapi.model.Person.Juridica;
import br.com.nimble.nimbleapi.service.Person.JuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/person-juridica")
public class JuridicaAPI {

    @Autowired
    JuridicaService service;

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/form")
    public Juridica setJuridicalPerson(@RequestBody Juridica resource)  {
        return this.service.createPJ(resource);
    }
}
