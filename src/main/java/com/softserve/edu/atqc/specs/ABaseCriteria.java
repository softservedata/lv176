package com.softserve.edu.atqc.specs;

abstract class ABaseCriteria {

	ABaseCriteria() {
	}

	public FlexAssert next() {
		return FlexAssert.get();
	}

}
