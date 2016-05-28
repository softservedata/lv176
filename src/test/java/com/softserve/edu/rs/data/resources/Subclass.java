package com.softserve.edu.rs.data.resources;

interface ISubclassName{
	IBuildSubclass setSubclassName(String subclassName);
}

interface IBuildSubclass {
	ISubclassExt build();
}

public class Subclass implements ISubclassName, IBuildSubclass, ISubclassExt{

	private String subclassName;
	private String descriptionParametr;
	private String unitOfMeasurement;
	private ParameterType parameterType;
	
	private Subclass() {
		this.descriptionParametr = new String();
		this.unitOfMeasurement = new String();
	}
	
	// static factory - - - - - - - - - -
	
		public static ISubclassName get() {
			return new Subclass();
		}
	
	// set - - - - - - - - - -
	
		public IBuildSubclass setSubclassName(String subclassName) {
			this.subclassName = subclassName;
			return this;
		}

		public Subclass build() {
			return this;
		}
		
		public ISubclassExt setDescriptionParametr(String descriptionParametr) {
			this.descriptionParametr = descriptionParametr;
			return this;
		}

		public ISubclassExt setUnitOfMeasurement(String unitOfMeasurement) {
			this.unitOfMeasurement = unitOfMeasurement;
			return this;
		}
		
		public ISubclassExt setParameterType(ParameterType parameterType) {
			this.parameterType = parameterType;
			return this;
		}

		// get - - - - - - - - - -

		public String getSubclassName() {
			return subclassName;
		}

		public String getDescriptionParametr() {
			return descriptionParametr;
		}

		public String getUnitOfMeasurement() {
			return unitOfMeasurement;
		}
		
		public ParameterType getParameterType() {
			return parameterType;
		}
		
		
		
		
		
}
