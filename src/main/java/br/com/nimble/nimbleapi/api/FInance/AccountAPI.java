package br.com.nimble.nimbleapi.api.FInance;

import br.com.nimble.nimbleapi.model.Finance.Account;
import br.com.nimble.nimbleapi.service.Finance.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountAPI {
    @Autowired
    AccountService service;

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/form")
    public ResponseEntity createTitle(@RequestBody Account resource)  {
        return ResponseEntity.ok(this.service.createAccount(resource));
    }
}