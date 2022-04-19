package aps.financemanagerapi.domain.card.service;

import aps.financemanagerapi.core.service.BasicCrudService;
import aps.financemanagerapi.domain.card.entity.Card;
import aps.financemanagerapi.domain.card.repository.CardRepository;
import aps.financemanagerapi.domain.card.repository.spec.CardSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CardService extends BasicCrudService<Card, Long> {

    @Autowired
    public CardService(final CardRepository repository, final CardSpec spec) {
        super(repository, spec, Card.class);
    }
}