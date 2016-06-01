package com.softserve.edu.atqc.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jWrapper implements ILogger {
    private final String PICTURE_PATH = "Path to Picture ";
    private static volatile Log4jWrapper instance = null;
    private Logger logger;

    private Log4jWrapper() {
        this.logger = LoggerFactory.getLogger(Log4jWrapper.class);
    }

    public static Log4jWrapper get() {
        if (instance == null) {
            synchronized (Log4jWrapper.class) {
                if (instance == null) {
                    instance = new Log4jWrapper();
                }
            }
        }
        return instance;
    }

    public void error(String message) {
    	if (this.logger.isErrorEnabled()) {
            // TODO Get Stack Trace
    		this.logger.error(message);
    	}
    }

    public void warning(String message) {
    	if (this.logger.isWarnEnabled()) {
	        // TODO Get Stack Trace
	    	this.logger.warn(message);
    	}
    }

    public void info(String message) {
    	if (this.logger.isInfoEnabled()) {
	        // TODO Get Stack Trace
	    	this.logger.info(message);
    	}
    }

    // TODO
    //void debug(String message) {}
    
    public void insertPathToScreenShot(String fileNamePath) {
        logger.error(PICTURE_PATH + fileNamePath);
    }

    // TODO
    //void insertPathToHtmlCode(String fileNamePath) {}

}
