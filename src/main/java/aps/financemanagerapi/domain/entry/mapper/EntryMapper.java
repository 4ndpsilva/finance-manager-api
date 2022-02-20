package aps.financemanagerapi.domain.entry.mapper;

import aps.financemanagerapi.core.mapper.GenericMapper;
import aps.financemanagerapi.domain.account.entity.Account;
import aps.financemanagerapi.domain.card.entity.Card;
import aps.financemanagerapi.domain.category.entity.Category;
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


    default Entry toEntity(EntryDTO dto){
        final Entry entry = new Entry();
        entry.setEntryDate(dto.entryDate());
        entry.setCategory(dto.categoryId() == null ? null : new Category(dto.categoryId()));
        entry.setAccount(dto.accountId() == null ? null : new Account(dto.accountId()));
        entry.setCard(dto.cardId() == null ? null : new Card(dto.cardId()));
        entry.setPaymentType(dto.paymentType());
        entry.setOperation(dto.operation());
        entry.setValue(dto.value());
        entry.setDiscount(dto.discount());
        entry.setObservation(dto.observation());
        return entry;
    }
}