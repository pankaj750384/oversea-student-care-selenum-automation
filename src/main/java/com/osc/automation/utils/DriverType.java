package com.osc.automation.utils;

public enum  DriverType {

	 CHROME("CHROME"), FIREFOX("FIREFOX"), IE("IE"); 
	  
    // declaring private variable for getting values 
    private String action; 
  
    // getter method 
    public String value() 
    { 
        return this.action; 
    } 
  
    // enum constructor - cannot be public or protected 
    private DriverType(String action) 
    { 
        this.action = action; 
    } 
}
