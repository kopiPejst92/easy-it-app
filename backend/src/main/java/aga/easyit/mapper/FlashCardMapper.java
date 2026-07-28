package aga.easyit.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import aga.easyit.dto.FlashCardDTO;
import aga.easyit.model.FlashCard;


@Mapper(componentModel="spring", uses={CommandMapper.class, ArgumentMapper.class})
public interface FlashCardMapper{
    FlashCardDTO toDto(FlashCard flashCard);

    List<FlashCardDTO> toDtoList(List<FlashCard> flashCards);

    FlashCard toEntity(FlashCardDTO flashCardDTO);
}
