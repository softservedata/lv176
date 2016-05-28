package com.softserve.edu.rs.data.resources;

import org.apache.commons.lang3.RandomStringUtils;

public class SubclassRepository {
	private static volatile SubclassRepository instance = null;

	private SubclassRepository() {
	}

	public static SubclassRepository get() {
		if (instance == null) {
			synchronized (SubclassRepository.class) {
				if (instance == null) {
					instance = new SubclassRepository();
				}
			}
		}
		return instance;
	}

	public ISubclass getOneLetterSubclassName() {
		return Subclass.get()
				.setSubclassName("A")
				.build();
	}
	
	public ISubclass getLettersSubclassName() {
		return Subclass.get()
				.setSubclassName("LettersSubclass")
				.build();
	}
	
	public ISubclass getOneNumberSubclassName() {
		return Subclass.get()
				.setSubclassName("1")
				.build();
	}
	
	public ISubclass getNumbersSubclassName() {
		return Subclass.get()
				.setSubclassName("1234567890")
				.build();
	}
	
	//------------------------------------------------------------------------------------
	
	public ISubclass getResCharsSubclass() {
		return Subclass.get()
				.setSubclassName("=/|\\*()_:;#%^?[]")
				.build();
	}
	
	public ISubclass getEqualCharsSubclass() {
		return Subclass.get()
				.setSubclassName("=")
				.build();
	}
	
	public ISubclass getSlashCharsSubclass() {
		return Subclass.get()
				.setSubclassName("/")
				.build();
	}
	
	public ISubclass getSeparatorCharsSubclass() {
		return Subclass.get()
				.setSubclassName("|")
				.build();
	}
	
	public ISubclass getBackSlashCharsSubclass() {
		return Subclass.get()
				.setSubclassName("\\")
				.build();
	}
	
	public ISubclass getSnowflakeCharsSubclass() {
		return Subclass.get()
				.setSubclassName("*")
				.build();
	}
	
	public ISubclass getLeftEarCharsSubclass() {
		return Subclass.get()
				.setSubclassName("(")
				.build();
	}
	
	public ISubclass getRightEarCharsSubclass() {
		return Subclass.get()
				.setSubclassName(")")
				.build();
	}
	
	public ISubclass getDashCharsSubclass() {
		return Subclass.get()
				.setSubclassName("_")
				.build();
	}
	
	public ISubclass getColonCharsSubclass() {
		return Subclass.get()
				.setSubclassName(":")
				.build();
	}
	
	public ISubclass getSemicolonCharsSubclass() {
		return Subclass.get()
				.setSubclassName(";")
				.build();
	}
	
	public ISubclass getSharpCharsSubclass() {
		return Subclass.get()
				.setSubclassName("#")
				.build();
	}
	
	public ISubclass getPercentCharsSubclass() {
		return Subclass.get()
				.setSubclassName("%")
				.build();
	}
	
	public ISubclass getCircumflexCharsSubclass() {
		return Subclass.get()
				.setSubclassName("^")
				.build();
	}
	
	public ISubclass getQuestionMarkCharsSubclass() {
		return Subclass.get()
				.setSubclassName("?")
				.build();
	}
	
	public ISubclass getLeftBracketCharsSubclass() {
		return Subclass.get()
				.setSubclassName("[")
				.build();
	}
	
	public ISubclass getRightBracketCharsSubclass() {
		return Subclass.get()
				.setSubclassName("]")
				.build();
	}
	
	//------------------------------------------------------------------------------------
	
	public ISubclass getRiverSubclass() {
		return Subclass.get()
				.setSubclassName("River")
				.build()
				.setDescriptionParametr("long")
				.setUnitOfMeasurement("meter")
				.setParameterType(ParameterType.DISCRETE);
	}
	
	//------------------------------------------------------------------------------------
	
	public ISubclass getRandomSubclassNoParams() {
		return Subclass.get()
				.setSubclassName(RandomStringUtils.randomAlphabetic(255))
				.build();
	}
	
	public ISubclass getRandomSubclassNoParamsMaxLength() {
		return Subclass.get()
				.setSubclassName(RandomStringUtils.randomAlphabetic(256))
				.build();
	}
	
	public ISubclass getRandomSubclass() {
		return Subclass.get()
				.setSubclassName(RandomStringUtils.randomAlphabetic(7))
				.build()
				.setDescriptionParametr(RandomStringUtils.randomAlphabetic(5))
				.setUnitOfMeasurement(RandomStringUtils.randomAlphabetic(5));
	}
	
}
