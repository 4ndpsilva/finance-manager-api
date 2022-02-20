package aps.financemanagerapi.domain.card.mapper;

import aps.financemanagerapi.core.mapper.GenericMapper;
import aps.financemanagerapi.domain.card.dto.CardDTO;
import aps.financemanagerapi.domain.card.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends GenericMapper<Card, CardDTO> { }