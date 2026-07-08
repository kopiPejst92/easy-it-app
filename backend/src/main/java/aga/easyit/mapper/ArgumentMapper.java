package aga.easyit.mapper;

import org.mapstruct.Mapper;

import aga.easyit.dto.ArgumentDTO;
import aga.easyit.model.Argument;

@Mapper(componentModel="spring")
public interface ArgumentMapper extends GenericMapper<Argument, ArgumentDTO>{

}
