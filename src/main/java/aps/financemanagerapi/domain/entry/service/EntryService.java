package aps.financemanagerapi.domain.entry.service;

import aps.financemanagerapi.core.service.BasicCrudService;
import aps.financemanagerapi.domain.account.service.AccountService;
import aps.financemanagerapi.domain.card.entity.Card;
import aps.financemanagerapi.domain.card.service.CardService;
import aps.financemanagerapi.domain.category.service.CategoryService;
import aps.financemanagerapi.domain.entry.entity.Entry;
import aps.financemanagerapi.domain.entry.entity.PaymentType;
import aps.financemanagerapi.domain.entry.repository.EntryRepository;
import aps.financemanagerapi.domain.entry.repository.spec.EntrySpec;
import aps.financemanagerapi.infrastructure.exception.BusinessException;
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
        validatePaymentType(entry);
        cardService.exist(entry.getCard());
    }

    private void validatePaymentType(Entry entry){
        final Card card = entry.getCard();

        if(card != null && card.getId() != null && entry.getPaymentType().equals(PaymentType.MONEY)){
            throw new BusinessException("API-015");
        }

        if((card == null || card.getId() == null) && !entry.getPaymentType().equals(PaymentType.MONEY)){
            throw new BusinessException("API-016");
        }
    }
}