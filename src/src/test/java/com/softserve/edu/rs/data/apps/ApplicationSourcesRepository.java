package com.softserve.edu.rs.data.apps;

import com.softserve.edu.atqc.data.apps.ApplicationSources;

public final class ApplicationSourcesRepository {
	private static volatile ApplicationSourcesRepository instance = null;

	private ApplicationSourcesRepository() {
	}

	public static ApplicationSourcesRepository get() {
		if (instance == null) {
			synchronized (ApplicationSourcesRepository.class) {
				if (instance == null) {
					instance = new ApplicationSourcesRepository();
				}
			}
		}
		return instance;
	}
	
	public ApplicationSources getLocalHostByDefaultBrowser() {
		ApplicationSources applicationSources = new ApplicationSources("http://localhost:8080/resources/login",
				"http://localhost:8080/resources/logout");
		applicationSources.setBrowserName("Browser default");
		return applicationSources;
	}

	public ApplicationSources getLocalHostByFirefoxTemporary() {
		ApplicationSources applicationSources = new ApplicationSources("http://localhost:8080/resources/login",
				"http://localhost:8080/resources/logout");
		applicationSources.setBrowserName("Firefox temporary");
		return applicationSources;
	}

	public ApplicationSources getLocalHostByFirefoxDefault() {
		ApplicationSources applicationSources = new ApplicationSources("http://localhost:8080/resources/login",
				"http://localhost:8080/resources/logout");
		applicationSources.setBrowserName("Firefox default");
		return applicationSources;
	}

	public ApplicationSources getLocalHostByChromeTemporary() {
		ApplicationSources applicationSources = new ApplicationSources("http://localhost:8080/resources/login",
				"http://localhost:8080/resources/logout");
		applicationSources.setBrowserName("Chrome temporary");
		return applicationSources;
	}

	public ApplicationSources getLocalHostByIETemporary() {
		ApplicationSources applicationSources = new ApplicationSources("http://localhost:8080/resources/login",
				"http://localhost:8080/resources/logout");
		applicationSources.setBrowserName("Internet Explorer temporary");
		return applicationSources;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public ApplicationSources getJavaTrainingLocalByDefaultBrowser() {
		ApplicationSources applicationSources = new ApplicationSources("http://java.training.local:8080/registrator/login",
				"http://java.training.local:8080/registrator/logout");
		applicationSources.setBrowserName("Browser default");
		return applicationSources;
	}

	public ApplicationSources getJavaTrainingLocalByFirefoxTemporary() {
		ApplicationSources applicationSources = new ApplicationSources("http://java.training.local:8080/registrator/login",
				"http://java.training.local:8080/registrator/logout");
		applicationSources.setBrowserName("Firefox temporary");
		return applicationSources;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public ApplicationSources getHerokuByDefaultBrowser() {
		ApplicationSources applicationSources = new ApplicationSources("http://registrator.herokuapp.com/login",
				"http://registrator.herokuapp.com/logout");
		applicationSources.setBrowserName("Browser default");
		return applicationSources;
	}

	public ApplicationSources getHerokuByFirefoxTemporary() {
		ApplicationSources applicationSources = new ApplicationSources("http://registrator.herokuapp.com/login",
				"http://registrator.herokuapp.com/logout");
		applicationSources.setBrowserName("Firefox temporary");
		return applicationSources;
	}

}
