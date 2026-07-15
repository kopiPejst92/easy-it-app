package aga.easyit.mapper;

import org.mapstruct.Mapper;

import aga.easyit.dto.ArgumentDTO;
import aga.easyit.model.Argument;

@Mapper(componentModel="spring", uses={CommandMapper.class})
    public abstract class ArgumentMapper{

        public abstract ArgumentDTO toDto(Argument argument);

        public abstract Argument toEntity(ArgumentDTO argumentDTO);

//    List<Argument> toEntityListFromRawString(String rawString){
//    }
}
