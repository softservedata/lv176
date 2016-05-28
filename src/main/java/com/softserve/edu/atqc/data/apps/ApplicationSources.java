package com.softserve.edu.atqc.data.apps;

interface IApplicationFactory {
	void setParameter(String parameter, ApplicationSources applicationSources);
}


class BrowserNameFactory implements IApplicationFactory {
	public void setParameter(String parameter, ApplicationSources applicationSources) {
		applicationSources.setBrowserName(parameter);
	}
}

class DriverPathFactory implements IApplicationFactory {
	public void setParameter(String parameter, ApplicationSources applicationSources) {
		applicationSources.setDriverPath(parameter);
	}
}

class BrowserPathFactory implements IApplicationFactory {
	public void setParameter(String parameter, ApplicationSources applicationSources) {
		applicationSources.setBrowserPath(parameter);
	}
}

class DefaulProfileFactory implements IApplicationFactory {
	public void setParameter(String parameter, ApplicationSources applicationSources) {
		applicationSources.setDefaulProfile(parameter);
	}
}

class ImplicitTimeOutFactory implements IApplicationFactory {
	public void setParameter(String parameter, ApplicationSources applicationSources) {
		applicationSources.setImplicitTimeOut(Long.parseLong(parameter));
	}
}

class ExplicitTimeOutFactory implements IApplicationFactory {
	public void setParameter(String parameter, ApplicationSources applicationSources) {
		applicationSources.setExplicitTimeOut(Long.parseLong(parameter));
	}
}

class LanguageFactory implements IApplicationFactory {
	public void setParameter(String parameter, ApplicationSources applicationSources) {
		applicationSources.setLanguage(parameter);
	}
}

class SearchStrategyFactory implements IApplicationFactory {
	public void setParameter(String parameter, ApplicationSources applicationSources) {
		applicationSources.setSearchStrategy(parameter);
	}
}

class LoggerStrategyFactory implements IApplicationFactory {
	public void setParameter(String parameter, ApplicationSources applicationSources) {
		applicationSources.setLoggerStrategy(parameter);
	}
}

class LoginUrlFactory implements IApplicationFactory {
	public void setParameter(String parameter, ApplicationSources applicationSources) {
		applicationSources.setLoginUrl(parameter);
	}
}

class LogoutUrlFactory implements IApplicationFactory {
	public void setParameter(String parameter, ApplicationSources applicationSources) {
		applicationSources.setLogoutUrl(parameter);
	}
}

// TODO Use Builder
public final class ApplicationSources {
	
	public static enum ParameterList {
		BROWSER_NAME("browserName", new BrowserNameFactory()),
		DRIVER_PATH("driverPath", new DriverPathFactory()),
		BROWSER_PATH("browserPath", new BrowserPathFactory()),
		DEFAUL_PROFILE("defaulProfile", new DefaulProfileFactory()),
		IMPLICIT_TIMEOUT("implicitTimeOut", new ImplicitTimeOutFactory()),
		EXPLICIT_TIMEOUT("explicitTimeOut", new ExplicitTimeOutFactory()),
		LANGUAGE_STRATEGY("language", new LanguageFactory()),
		SEARCH_STRATEGY("searchStrategy", new SearchStrategyFactory()),
		LOGGER_STRATEGY("loggerStrategy", new LoggerStrategyFactory()),
		LOGIN_URL("loginUrl", new LoginUrlFactory()),
		LOGOUT_URL("logoutUrl", new LogoutUrlFactory());
        //
		private String field;
        private IApplicationFactory applicationFactory;

        private ParameterList(String field, IApplicationFactory applicationFactory) {
        	this.field = field;
            this.applicationFactory = applicationFactory;
        }

        public void setParameter(String parameter, ApplicationSources applicationSources) {
        	applicationFactory.setParameter(parameter, applicationSources);
        }
        
        @Override
        public String toString() {
            return this.field;
        }
    }

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
	// Localization Strategy
	private String language;
	// Search Strategy
	private String searchStrategy;
	// Logger Strategy
	private String loggerStrategy;
	// URLs
	private String loginUrl;
	private String logoutUrl;
	private String serverUrl;
	// TODO Add DataSource Parameters (4 items)
	// TODO Sleep for Demo

	public ApplicationSources(String loginUrl, String logoutUrl) {
		this.browserName = "";
		this.driverPath = "";
		this.browserPath = "";
		this.defaulProfile = "";
		// Implicit and Explicit Waits
		this.implicitTimeOut = 5;
		this.explicitTimeOut = 5;
		// Localization Strategy
		this.language = "українська";
		// Search Strategy
		this.searchStrategy = "Explicit Waits";
		// Logger Strategy
		this.loggerStrategy = "";
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
		return this.browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getDriverPath() {
		return this.driverPath;
	}

	public void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}

	public String getBrowserPath() {
		return this.browserPath;
	}

	public void setBrowserPath(String browserPath) {
		this.browserPath = browserPath;
	}

	public String getDefaulProfile() {
		return this.defaulProfile;
	}

	public void setDefaulProfile(String defaulProfile) {
		this.defaulProfile = defaulProfile;
	}

	public long getImplicitTimeOut() {
		return this.implicitTimeOut;
	}

	public void setImplicitTimeOut(long implicitTimeOut) {
		this.implicitTimeOut = implicitTimeOut;
	}

	public long getExplicitTimeOut() {
		return this.explicitTimeOut;
	}

	public void setExplicitTimeOut(long explicitTimeOut) {
		this.explicitTimeOut = explicitTimeOut;
	}
	
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getSearchStrategy() {
		return this.searchStrategy;
	}

	public void setSearchStrategy(String searchStrategy) {
		this.searchStrategy = searchStrategy;
	}

	public String getLoggerStrategy() {
		return this.loggerStrategy;
	}

	public void setLoggerStrategy(String loggerStrategy) {
		this.loggerStrategy = loggerStrategy;
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