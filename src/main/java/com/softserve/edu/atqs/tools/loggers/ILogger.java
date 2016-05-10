package com.softserve.edu.atqs.tools.loggers;

public interface ILogger {

    void error(String message);

    void warning(String message);

    void info(String message);

    void insertScreenShot(String fileNamePath);

}
