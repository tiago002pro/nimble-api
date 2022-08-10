package br.com.nimble.nimbleapi.api.Finance;

import br.com.nimble.nimbleapi.model.Finance.Account;
import br.com.nimble.nimbleapi.service.Finance.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountAPI {
    @Autowired
    AccountService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public ResponseEntity createAccount(@RequestBody Account resource)  {
        return ResponseEntity.ok(this.service.createAccount(resource));
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity getAllAccounts(@RequestParam(defaultValue = "1", required = false) int page,
                                         @RequestParam(defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok(this.service.getAllAccounts(PageRequest.of(page > 0 ? --page : 0, size)));
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getByid(@PathVariable Long id)  {
        return ResponseEntity.ok(this.service.getById(id));
    }


}