package com.app.logger.impl;

import com.app.logger.LoggerProcessor;

public class InfoLogProcessor extends LoggerProcessor {
    public InfoLogProcessor(LoggerProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void logMessage(int logLevel, String message) {
        if(logLevel == INFO) {
            System.out.println("INFO : " + message);
        } else {
            super.logMessage(logLevel, message);
        }
    }
}
