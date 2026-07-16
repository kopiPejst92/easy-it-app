package aga.easyit.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;

import aga.easyit.dto.ArgumentDTO;
import aga.easyit.model.Argument;
import aga.easyit.model.Command;

@Mapper(componentModel="spring", uses={CommandMapper.class})
    public abstract class ArgumentMapper{

        public abstract ArgumentDTO toDto(Argument argument);

        public abstract Argument toEntity(ArgumentDTO argumentDTO);

        List<Argument> toEntityListFromRawString(String rawString){
            return null;
            
   }
}
