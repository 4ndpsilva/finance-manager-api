package aps.financemanagerapi.domain.account.mapper;


import aps.financemanagerapi.core.mapper.GenericMapper;
import aps.financemanagerapi.domain.account.dto.AccountDTO;
import aps.financemanagerapi.domain.account.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper extends GenericMapper<Account, AccountDTO> {
    @Mapping(source = "categoryId", target = "category.id")
    Account toEntity(AccountDTO dto);

    @Mapping(source = "category.id", target = "categoryId")
    AccountDTO toDTO(Account entity);
}