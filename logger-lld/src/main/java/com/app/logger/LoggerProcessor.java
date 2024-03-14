package com.app.logger;

public abstract class LoggerProcessor {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    private LoggerProcessor nextLoggerProcessor;

    public LoggerProcessor(LoggerProcessor nextLoggerProcessor) {
        this.nextLoggerProcessor = nextLoggerProcessor;
    }

    public void logMessage(int logLevel, String message) {
        if(nextLoggerProcessor != null) {
            nextLoggerProcessor.logMessage(logLevel, message);
        }
    }
}
