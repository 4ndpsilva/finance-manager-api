package aps.financemanagerapi.domain.entry.service;

import aps.financemanagerapi.core.service.BasicCrudService;
import aps.financemanagerapi.domain.entry.entity.Entry;
import aps.financemanagerapi.domain.entry.repository.EntryRepository;
import aps.financemanagerapi.domain.entry.repository.spec.EntrySpec;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EntryService extends BasicCrudService<Entry, Long> {
    public EntryService(final EntryRepository repository, final EntrySpec spec){
        super(repository, spec, Entry.class);
    }
}