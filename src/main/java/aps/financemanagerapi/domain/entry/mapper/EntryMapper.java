package aps.financemanagerapi.domain.entry.mapper;

import aps.financemanagerapi.core.mapper.GenericMapper;
import aps.financemanagerapi.domain.entry.dto.EntryDTO;
import aps.financemanagerapi.domain.entry.entity.Entry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntryMapper extends GenericMapper<Entry, EntryDTO> {

    @Mappings({
            @Mapping(source = "category.id", target = "categoryId"),
            @Mapping(source = "account.id", target = "accountId"),
            @Mapping(source = "card.id", target = "cardId"),
            @Mapping(source = "entity.entryDate", target = "entryDate", dateFormat = "dd/MM/yyyy")
    })
    EntryDTO toDTO(Entry entity);


    @Mappings({
            @Mapping(source = "categoryId", target = "category.id"),
            @Mapping(source = "accountId", target = "account.id"),
            @Mapping(source = "cardId", target = "card.id")
    })
    Entry toEntity(EntryDTO dto);
}