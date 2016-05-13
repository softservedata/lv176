package com.softserve.edu.atqc.loggers;

import com.softserve.edu.atqc.data.apps.ApplicationSources;

public class LoggerUtils {
	private final String LOG4J = "log4j";
	private final String REPORTER = "reporter";
    private static volatile LoggerUtils instance = null;
    private ILogger logger;

    private LoggerUtils() {
        // Set Strategy by Default.
        //this.logger = LoggerRepository.getReporterLogger();
    }

	public static LoggerUtils get() {
		return get(null); 
	}

    public static LoggerUtils get(ApplicationSources applicationSources) {
        if (instance == null) {
            synchronized (LoggerUtils.class) {
                if (instance == null) {
                    instance = new LoggerUtils();
                }
            }
        }
        instance.checkStatus(applicationSources);
        return instance;
    }

	private void checkStatus(ApplicationSources applicationSources) {
		/*-
				AS		loggerStrategy		logger	Action
				+		+					+/-		set (check, else default)
		 *		+		-					+		-
		 *		+		-					-		defaul
		 *		-		-					+		-
		 *		-		-					-		defaul
		 */		
		if ((applicationSources != null)
				&& (applicationSources.getLoggerStrategy() != null)
				&& !applicationSources.getLoggerStrategy().isEmpty()) {
			if (applicationSources.getLoggerStrategy().toLowerCase().contains(LOG4J)) {
				setLog4JStrategy();
			} else if (applicationSources.getSearchStrategy().toLowerCase().contains(REPORTER)) {
				setReporterStrategy();
			} else {
				setLogger(LoggerRepository.getLoggerDefault());
			}
		} else {
			if ( getLogger() == null) {
				setLogger(LoggerRepository.getLoggerDefault());
			}
		}
	}

	private ILogger getLogger() {
		return this.logger;
	}

    // Set Strategy.
    public LoggerUtils setLogger(ILogger logger) {
        synchronized (LoggerUtils.class) {
            this.logger = logger;
        }
        return this;
    }

    public LoggerUtils setLog4JStrategy() {
        return setLogger(LoggerRepository.getLog4jLogger());
    }

    public LoggerUtils setReporterStrategy() {
        return setLogger(LoggerRepository.getReporterLogger());
    }

    public void errorLog(String message) {
        // TODO getClass, getMethod
        this.logger.error(message);
    }

    public void warningLog(String message) {
        // TODO getClass, getMethod
        this.logger.warning(message);
    }

    public void infoLog(String message) {
        // TODO getClass, getMethod
        this.logger.info(message);
    }

    //public void debugLog(String message) {}
    
    public void insertPathToScreenShot(String fileNamePath) {
        this.logger.insertPathToScreenShot(fileNamePath);
    }

    // TODO
    //void insertPathToHtmlCode(String fileNamePath) {}
    
}
