package aps.financemanagerapi.domain.account.service;

import aps.financemanagerapi.core.service.BasicCrudService;
import aps.financemanagerapi.domain.account.entity.Account;
import aps.financemanagerapi.domain.account.repository.AccountRepository;
import aps.financemanagerapi.domain.account.repository.spec.AccountSpec;
import aps.financemanagerapi.infrastructure.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BasicCrudService<Account, Long> {
    private final AccountRepository repository;

    @Autowired
    public AccountService(final AccountRepository repository, final AccountSpec spec) {
        super(repository, spec, Account.class);
        this.repository = repository;
    }

    public void validate(final Account account){
        if(!repository.existsById(account.getId())){
            throw new ResourceNotFoundException("API-013");
        }
    }
}