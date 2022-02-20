package aps.financemanagerapi.domain.card.repository;

import aps.financemanagerapi.core.repository.BaseRepository;
import aps.financemanagerapi.domain.card.entity.Card;

import java.util.UUID;

public interface CardRepository extends BaseRepository<Card, UUID> { }