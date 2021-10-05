package br.com.nimble.nimbleapi.api.Person;

import br.com.nimble.nimbleapi.model.Person.Juridica;
import br.com.nimble.nimbleapi.service.Person.JuridicaService;
import br.com.nimble.nimbleapi.service.Person.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserAPI {

    @Autowired
    UserService service;

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/validate-login")
    public ResponseEntity setJuridicalPerson(@RequestParam(value = "login") String login, @RequestParam(value = "password") String password)  {
        return  ResponseEntity.ok(this.service.validateLogin(login, password));
    }
}
