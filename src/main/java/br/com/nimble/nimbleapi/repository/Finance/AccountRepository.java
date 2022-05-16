package br.com.nimble.nimbleapi.repository.Finance;

import br.com.nimble.nimbleapi.model.Finance.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {}