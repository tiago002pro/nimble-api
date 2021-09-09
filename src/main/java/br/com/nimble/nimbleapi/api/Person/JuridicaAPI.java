package br.com.nimble.nimbleapi.api.Person;

import br.com.nimble.nimbleapi.model.Person.Juridica;
import br.com.nimble.nimbleapi.service.Person.JuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/person-juridica")
public class JuridicaAPI {

//    @Autowired(required=true)
//    JuridicaService service;
//
//    @RequestMapping(method = RequestMethod.POST, value = "/form/pj")
//    public String setPerson(Map<String, Object> json) throws ParseException {
//        return this.service.createPersonJuridica(json);
//    }
//
//    @GetMapping("/get/pj")
//    public List<Juridica> gerListPerson() {
//        return this.service.getLisPersonJuridica();
//    }
}
