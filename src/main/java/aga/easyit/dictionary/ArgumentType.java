package aga.easyit.dictionary;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ArgumentType {
    PARAMETER("Parameter"),
    FLAG("Flag"),
    OPTION("Option"),
    POSITIONAL_ARGUMENT("Positional argument");

    private final String typeName;
    
    ArgumentType(String typeName){
        this.typeName=typeName;
    }

    @JsonValue
    private String getTypeName() {
        return this.typeName;
    }
}
