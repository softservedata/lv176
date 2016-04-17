package com.softserve.edu.rs.data.testdata;

public final class TestData {
	
	private String deleteTeritories;
	private String procuration;
	private String emptyField;
	private String passport;
	private String mapInstruction;
	
	private TestData(){
		this.deleteTeritories = new String();
		this.procuration = new String();
		this.emptyField = new String();
		this.passport = new String();
		this.mapInstruction = new String();
		
	}
	
	public static TestData get(){
		return new TestData();
	}
	
	//set
	
	public TestData setDeleteTeritories(String deleteTeritories){
		this.deleteTeritories = deleteTeritories;
		return this;
	}
	
	public TestData setProcuration(String procuration){
		this.procuration = procuration;
		return this;
	}
	
	public TestData setEmptyField(String emptyField){
		this.emptyField = emptyField;
		return this;
	}
	
	public TestData setPassport(String passport){
		this.passport = passport;
		return this;
	}
	
	public TestData setMapInstruction(String mapInstruction){
		this.mapInstruction = mapInstruction;
		return this;
	}
	
	
	//get
	
	public String getDeleteTeritories(){
		return deleteTeritories;
	}
	
	public String getProcuration(){
		return procuration;
	}
	
	public String getEmptyField(){
		return emptyField;
	}
	
	public String getPassport(){
		return passport;
	}
	
	public String getMapInstruction(){
		return mapInstruction;
	}

}
