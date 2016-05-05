package com.softserve.edu.atqc.data.apps;

// TODO Use Builder
public final class ApplicationSources {
	private final String SLASH = "/";
	private final String SEPARATOR = "://";
	private final int AFTER_SEPARATOR = 3;
	//
	// Browser Data
	private String browserName;
	private String driverPath;
	private String browserPath;
	private String defaulProfile;
	// Implicit and Explicit Waits
	private long implicitTimeOut;
	private long explicitTimeOut;
	// Search Strategy
	private String searchStrategy;
	// URLs
	private String loginUrl;
	private String logoutUrl;
	private String serverUrl;
	// TODO Logger Strategy
	// TODO Sleep for Demo

	public ApplicationSources(String loginUrl, String logoutUrl) {
		this.browserName = "";
		this.driverPath = "";
		this.browserPath = "";
		this.defaulProfile = "";
		// Implicit and Explicit Waits
		this.implicitTimeOut = 5;
		this.explicitTimeOut = 5;
		// Search Strategy
		this.searchStrategy = "";
		// URLs
		this.loginUrl = loginUrl;
		this.logoutUrl = logoutUrl;
		//
		this.serverUrl = parseServerUrl();
	}

	// TODO Builder
	// public static ApplicationSources get() {
	// return new ApplicationSources();
	// }

	private String parseServerUrl() {
		String result = loginUrl.substring(loginUrl.indexOf(SEPARATOR) < 0 ? 0 : loginUrl.indexOf(SEPARATOR) + AFTER_SEPARATOR);
		return result.substring(0, result.indexOf(SLASH));
	}

	// get

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getDriverPath() {
		return driverPath;
	}

	public void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}

	public String getBrowserPath() {
		return browserPath;
	}

	public void setBrowserPath(String browserPath) {
		this.browserPath = browserPath;
	}

	public String getDefaulProfile() {
		return defaulProfile;
	}

	public void setDefaulProfile(String defaulProfile) {
		this.defaulProfile = defaulProfile;
	}

	public long getImplicitTimeOut() {
		return implicitTimeOut;
	}

	public void setImplicitTimeOut(long implicitTimeOut) {
		this.implicitTimeOut = implicitTimeOut;
	}

	public long getExplicitTimeOut() {
		return explicitTimeOut;
	}

	public void setExplicitTimeOut(long explicitTimeOut) {
		this.explicitTimeOut = explicitTimeOut;
	}

	public String getSearchStrategy() {
		return searchStrategy;
	}

	public void setSearchStrategy(String searchStrategy) {
		this.searchStrategy = searchStrategy;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	public String getServerUrl() {
		return serverUrl;
	}

}
