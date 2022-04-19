package br.com.nimble.nimbleapi.service.Finance;

import br.com.nimble.nimbleapi.model.Finance.Account;
import br.com.nimble.nimbleapi.repository.Finance.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;

    public Account createAccount(Account resource) {
        return this.repository.save(resource);
    }
}