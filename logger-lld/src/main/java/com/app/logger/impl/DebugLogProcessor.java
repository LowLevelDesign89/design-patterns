package com.app.logger.impl;

import com.app.logger.LoggerProcessor;

public class DebugLogProcessor extends LoggerProcessor {
    public DebugLogProcessor(LoggerProcessor nextLoggerProcessor) {
        super(nextLoggerProcessor);
    }

    public void logMessage(int logLevel, String message) {
        if(logLevel == DEBUG) {
            System.out.println("DEBUG : " + message);
        } else {
            super.logMessage(logLevel, message);
        }
    }
}
