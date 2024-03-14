package com.app.logger.impl;

import com.app.logger.LoggerProcessor;

public class ErrorLogProcessor extends LoggerProcessor {
    public ErrorLogProcessor(LoggerProcessor nextLoggerProcessor) {
        super(nextLoggerProcessor);
    }

    public void logMessage(int logLevel, String message) {
        if(logLevel == ERROR) {
            System.out.println("ERROR : " + message);
        } else {
            super.logMessage(logLevel, message);
        }
    }
}
