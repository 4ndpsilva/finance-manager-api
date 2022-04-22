package aps.financemanagerapi.domain.entry.service;

import aps.financemanagerapi.core.service.BasicCrudService;
import aps.financemanagerapi.domain.account.service.AccountService;
import aps.financemanagerapi.domain.card.service.CardService;
import aps.financemanagerapi.domain.category.service.CategoryService;
import aps.financemanagerapi.domain.entry.entity.Entry;
import aps.financemanagerapi.domain.entry.repository.EntryRepository;
import aps.financemanagerapi.domain.entry.repository.spec.EntrySpec;
import org.springframework.stereotype.Service;

@Service
public class EntryService extends BasicCrudService<Entry, Long> {
    private final EntryRepository repository;
    private final CategoryService categoryService;
    private final AccountService accountService;
    private final CardService cardService;

    public EntryService(final EntryRepository repository,
                        final CategoryService categoryService,
                        final AccountService accountService,
                        final CardService cardService,
                        final EntrySpec spec){

        super(repository, spec, Entry.class);
        this.repository = repository;
        this.categoryService = categoryService;
        this.accountService = accountService;
        this.cardService = cardService;
    }

    @Override
    public void validate(final Entry entry) {
        categoryService.exist(entry.getCategory());
        accountService.exist(entry.getAccount());
        cardService.exist(entry.getCard());
    }
}