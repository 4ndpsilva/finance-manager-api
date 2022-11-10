package aps.financemanagerapi.domain.card.service;

import aps.financemanagerapi.core.service.BasicCrudService;
import aps.financemanagerapi.domain.card.entity.Card;
import aps.financemanagerapi.domain.card.repository.CardRepository;
import aps.financemanagerapi.domain.card.repository.spec.CardSpec;
import aps.financemanagerapi.infrastructure.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService extends BasicCrudService<Card, Long> {
    private final CardRepository repository;

    @Autowired
    public CardService(final CardRepository repository, final CardSpec spec) {
        super(repository, spec, Card.class);
        this.repository = repository;
    }

    public void validate(final Card card){
        if(card != null && card.getId() != null){
            if(!repository.existsById(card.getId())){
                throw new ResourceNotFoundException("API-014");
            }
        }
    }
}