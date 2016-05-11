package com.softserve.edu.rs.data.testdata;


interface Ip1LatitudeGrad {
	Ip1LongitudedeGrad setp1LatitudeGrad(String p1LatitudeGrad);
}

interface Ip1LongitudedeGrad {
	Ip2LatitudeGrad setp1LongitudedeGrad(String p1LongitudedeGrad);
}

interface Ip2LatitudeGrad {
	Ip2LongitudedeGrad setp2LatitudeGrad(String p2LatitudeGrad);
}

interface Ip2LongitudedeGrad {
	Ip3LatitudeGrad setp2LongitudedeGrad(String p2LongitudedeGrad);
}

interface Ip3LatitudeGrad {
	Ip3LongitudedeGrad setp3LatitudeGrad(String p3LatitudeGrad);
}

interface Ip3LongitudedeGrad {
	IBuildCoordinatesData setp3LongitudedeGrad(String p3LongitudedeGrad);
}

interface IBuildCoordinatesData {
	CoordinatesData build();
}


public final class CoordinatesData implements Ip1LatitudeGrad, Ip1LongitudedeGrad, Ip2LatitudeGrad
                   ,Ip2LongitudedeGrad,  Ip3LatitudeGrad, Ip3LongitudedeGrad, IBuildCoordinatesData{
	
	private String p1LatitudeGrad;
	private String p1LongitudedeGrad;
	private String p2LatitudeGrad;
	private String p2LongitudedeGrad;
	private String p3LatitudeGrad;
	private String p3LongitudedeGrad;
	

	private CoordinatesData(){	
	}
	
	// static factory
	
	public static Ip1LatitudeGrad get(){
		return new CoordinatesData();
	}
	
	// set - - - - - - - - - -
	
	public Ip1LongitudedeGrad setp1LatitudeGrad(String p1LatitudeGrad){
		this.p1LatitudeGrad = p1LatitudeGrad;
		return this;
	}
	
	public Ip2LatitudeGrad setp1LongitudedeGrad(String p1LongitudedeGrad){
		this.p1LongitudedeGrad = p1LongitudedeGrad;
		return this;
	}
	
	public Ip2LongitudedeGrad setp2LatitudeGrad(String p2LatitudeGrad){
		this.p2LatitudeGrad = p2LatitudeGrad;
		return this;
	}
	
	public Ip3LatitudeGrad setp2LongitudedeGrad(String p2LongitudedeGrad){
		this.p2LongitudedeGrad = p2LongitudedeGrad;
		return this;
	}
	
	public Ip3LongitudedeGrad setp3LatitudeGrad(String p3LatitudeGrad){
		this.p3LatitudeGrad = p3LatitudeGrad;
		return this;
	}
	
	public IBuildCoordinatesData setp3LongitudedeGrad(String p3LongitudedeGrad){
		this.p3LongitudedeGrad = p3LongitudedeGrad;
		return this;
	}
	
	public CoordinatesData build(){
		return this;
	}
	
	// get - - - - - - - - - -
	
	public String getP1LatitudeGrad(){
		return p1LatitudeGrad;
	}
	
	public String getP1LLongitudeGrad(){
		return p1LongitudedeGrad;
	}
	
	public String getP2LatitudeGrad(){
		return p2LatitudeGrad;
	}
	
	public String getP2LLongitudeGrad(){
		return p2LongitudedeGrad;
	}
	
	public String getP3LatitudeGrad(){
		return p3LatitudeGrad;
	}
	
	public String getP3LLongitudeGrad(){
		return p3LongitudedeGrad;
	}
	
}
