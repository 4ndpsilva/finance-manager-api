package aps.financemanagerapi.domain.entry.repository;

import aps.financemanagerapi.core.repository.BaseRepository;
import aps.financemanagerapi.domain.entry.entity.Entry;

import java.util.UUID;

public interface EntryRepository extends BaseRepository<Entry, UUID> { }