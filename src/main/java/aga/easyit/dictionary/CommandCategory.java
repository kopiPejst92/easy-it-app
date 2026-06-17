package aga.easyit.dictionary;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CommandCategory{ 
    FILE_MANAGEMENT("File management"),
    PACKAGE_MANAGEMENT("Package management"),
    FRAMEWORK_SPECIFIC("Framework-specific"),
    LANGUAGE_SPECIFIC("Language-specific"),
    SYSTEM_SPECIFIC("System-specific"),
    SYSTEM_CONFIGURATION("System configuration"),
    ENVIRONMENT_CONFIGURATION("Environment configuration"),
    NET_CONFIGURATION("Net configuration");

    private final String categoryName;
    
    CommandCategory(String categoryName){
        this.categoryName=categoryName;
    }

    @JsonValue
    private String getCategoryName() {
        return this.categoryName;
    }
}
