package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.Select;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;

public class AppTest {

	//@Test
	public void testApp() {
		// System.out.println("\nALL Property: " +
		// java.lang.System.getProperties());
		System.out.println("\nsurefire.reports.directory = "
				+ System.getProperty("surefire.reports.directory"));
		System.out.println("\nselenium-version = "
				+ System.getProperty("selenium-version"));
		//
		long usedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		System.out.println("\nUsed Memory = "
				+ usedMemory / (1024.0 * 1024.0) + "Mb");
		System.out.println("\nTotal Amount of Memory = "
				+ Runtime.getRuntime().totalMemory() / (1024.0 * 1024.0) + "Mb");
		System.out.println("\nMaximum Amount of Memory = "
				+ Runtime.getRuntime().maxMemory() / (1024.0 * 1024.0) + "Mb");
		Assert.assertTrue(true);
	}

	@Test
	public void test2() throws Exception {
		Application application = Application
				.get(ApplicationSourcesRepository.get().getJavaTrainingLocalByFirefoxTemporary());
		//LoginPage loginPage = application.load();
		application.load();
		Thread.sleep(2000);
		System.out.println("START");
		ISelect select = Select.get().getById("changeLanguage");
		select.selectByPartialText("english");
		Thread.sleep(2000);
		select = Select.get().getById("changeLanguage");
		System.out.println("SELECT TEXT = " + select.getText()
			+ "\n SELECT FirstSelectedOption = " + select.getFirstSelectedOption().getText());
		select.selectByPartialText("укр");
		Thread.sleep(4000);
		application.quit();
	}

}
