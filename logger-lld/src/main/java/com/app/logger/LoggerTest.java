package com.app.logger;

import com.app.logger.impl.DebugLogProcessor;
import com.app.logger.impl.ErrorLogProcessor;
import com.app.logger.impl.InfoLogProcessor;

public class LoggerTest {
    public static void main(String[] args) {
        LoggerProcessor loggerProcessor = new InfoLogProcessor(
                new DebugLogProcessor(
                        new ErrorLogProcessor(null)));

        loggerProcessor.logMessage(LoggerProcessor.ERROR, "There is an error");
        loggerProcessor.logMessage(LoggerProcessor.DEBUG, "We need to debug this");
        loggerProcessor.logMessage(LoggerProcessor.INFO, "This is an info message");
    }
}
