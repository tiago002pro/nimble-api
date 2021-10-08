package br.com.nimble.nimbleapi.api.Person;

import br.com.nimble.nimbleapi.service.Person.NimbleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authenticated")
public class NimbleUserAPI {

    @Autowired
    NimbleUserService service;

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public ResponseEntity autUser(@RequestParam(value = "username") String username) {
        return ResponseEntity.ok(this.service.loadUserByUsername(username));
    }
}
