package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppIT {

	@Test
	public void testIntegrationApp() {
		// System.out.println("\nALL Property: " +
		// java.lang.System.getProperties());
		System.out.println("\nsurefire.reports.directory = "
				+ System.getProperty("surefire.reports.directory"));
		System.out.println("\nselenium-version = "
				+ System.getProperty("selenium-version"));
		Assert.assertTrue(true);
	}
}
