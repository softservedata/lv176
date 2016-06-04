
package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.RegistratorHomePage;
import com.softserve.edu.rs.pages.ResourceSearchPage;

public class SmokeResourceSearchTest {

	@DataProvider //(parallel = true)
	public Object[][] getApplicationSources() {
		return new Object[][] { { ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary(),
				UserRepository.get().getRegistrator() },
	//		{ ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary(),
	//				UserRepository.get().getCoowner() }
	//		{ ApplicationSourcesRepository.get().getLocalHostByIETemporary(),
	//				UserRepository.get().getRegistrator() }
		};
	}

	@Test(dataProvider = "getApplicationSources")
	public void registratorLogin(ApplicationSources applicationSources, IUser user) {
		Application application = Application.get(applicationSources);
		RegistratorHomePage registratorHomePage = application.load()
				.successRegistratorLogin(user);
		ResourceSearchPage spage = registratorHomePage.gotoResourcesSearchPage().clickSearchByCoordinate();
		Assert.assertTrue(spage.getSearchByPointComponent().getSearchByCoordinateLatitudeDegrees().isDisplayed(),"Search by Coordinate button isn't displayed");
		spage = spage.clickSearchByArea();
		Assert.assertTrue(spage.getSearchByAreaComponent().getSearchByAreaLatitudeDegrees1().isDisplayed(),"Text input for degrees isn't displayed");

		spage = spage.clickSearchByParameters();
		Assert.assertTrue(spage.getSearchByParametersComponent().getInputPerimeter().isDisplayed(),"Text input for perimeter isn't displayed");
		application.quit();

	}
}
