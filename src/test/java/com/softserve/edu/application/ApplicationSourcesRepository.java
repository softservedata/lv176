package com.softserve.edu.application;

public class ApplicationSourcesRepository {
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

	public ApplicationSources getLocalHostByFirefox() {
		return ApplicationSources.get()
				.setLoginUrl("http://localhost:8080/resources/login")
				.setLogoutUrl("http://localhost:8080/resources/logout")
				.setImplicitTimeOut(5)
				.setBrowserName("firefox");
	}

}
