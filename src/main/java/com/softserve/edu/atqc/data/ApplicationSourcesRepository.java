package com.softserve.edu.atqc.data;

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

}
