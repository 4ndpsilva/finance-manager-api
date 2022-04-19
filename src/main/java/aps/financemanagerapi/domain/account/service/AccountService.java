package aps.financemanagerapi.domain.account.service;

import aps.financemanagerapi.core.service.BasicCrudService;
import aps.financemanagerapi.domain.account.entity.Account;
import aps.financemanagerapi.domain.account.repository.AccountRepository;
import aps.financemanagerapi.domain.account.repository.spec.AccountSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService extends BasicCrudService<Account, Long> {

    @Autowired
    public AccountService(final AccountRepository repository, final AccountSpec spec) {
        super(repository, spec, Account.class);
    }
}