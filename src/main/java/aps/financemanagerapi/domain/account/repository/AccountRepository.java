package aps.financemanagerapi.domain.account.repository;

import aps.financemanagerapi.core.repository.BaseRepository;
import aps.financemanagerapi.domain.account.entity.Account;

import java.util.UUID;

public interface AccountRepository extends BaseRepository<Account, UUID> { }