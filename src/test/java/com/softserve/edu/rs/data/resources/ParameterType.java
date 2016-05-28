package com.softserve.edu.rs.data.resources;
public enum ParameterType {
    
	CHOSE(""),
    LINEAR("linearParameters"),
    DISCRETE("discreteParameters");

    private final String value;

    ParameterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
