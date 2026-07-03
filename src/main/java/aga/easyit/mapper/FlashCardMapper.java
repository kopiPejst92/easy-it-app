package aga.easyit.mapper;

import org.mapstruct.Mapper;

import aga.easyit.dto.FlashCardDTO;
import aga.easyit.model.FlashCard;

@Mapper(componentModel="spring")
public interface FlashCardMapper extends GenericMapper<FlashCard, FlashCardDTO>{

}
