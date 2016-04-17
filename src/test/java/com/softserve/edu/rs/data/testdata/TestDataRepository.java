package com.softserve.edu.rs.data.testdata;

public class TestDataRepository {
	private static volatile TestDataRepository instance = null;

	private TestDataRepository() {
	}

	public static TestDataRepository get() {
		if (instance == null) {
			synchronized (TestDataRepository.class) {
				if (instance == null) {
					instance = new TestDataRepository();
				}
			}
		}
		return instance;
	}

	public TestData getTestData() {
		return TestData.get()
				.setDeleteTeritories("Видалити всі території")
				.setEmptyField("")
				.setProcuration("доручення")
				.setPassport("паспорт")
				.setMapInstruction("Щоб додати область натисніть кнопку \"Додати полігон\"");
	}
}
