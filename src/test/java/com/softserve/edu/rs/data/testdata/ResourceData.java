package com.softserve.edu.rs.data.testdata;

public final class ResourceData {
	
	private String resourceName;
	private String resourceNumber;
	
	private ResourceData(){
		this.resourceName = new String();
		this.resourceNumber = new String();
	
	}
	
	public static ResourceData get(){
		return new ResourceData();
	}
	
	//set
	
	public ResourceData setResourceName(String resourceName){
		this.resourceName = resourceName;
		return this;
	}
	
	public ResourceData setResourceNumber(String resourceNumber){
		this.resourceNumber = resourceNumber;
		return this;
	}
	
	
	//get
	
	public String getResourceName(){
		return resourceName;
	}
	
	public String getResourceNumber(){
		return resourceNumber;
	}


}
