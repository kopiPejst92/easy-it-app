package aga.easyit.mapper;

import org.mapstruct.Mapper;

import aga.easyit.dto.CommandDTO;
import aga.easyit.model.Command;

@Mapper(componentModel="spring")
public interface CommandMapper extends GenericMapper<Command, CommandDTO>{

}
