package br.com.nimble.nimbleapi.service.Finance;

import br.com.nimble.nimbleapi.model.Finance.Account;
import br.com.nimble.nimbleapi.model.Finance.Title;
import br.com.nimble.nimbleapi.repository.Finance.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;

    @Transactional
    public Account createAccount(Account account) {
        return this.repository.save(account);
    }

    @Transactional
    public Page<Account> getAllAccounts(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Transactional
    public Account getById(Long id) {
        return this.repository.findById(id).get();
    }
}