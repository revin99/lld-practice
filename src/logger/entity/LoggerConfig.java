package logger.entity;

import logger.strategy.Appender;

public class LoggerConfig {

    private LogLevel logLevel;
    private Appender logAppender;

    public LoggerConfig(LogLevel logLevel, Appender logAppender) {
        this.logLevel = logLevel;
        this.logAppender = logAppender;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public Appender getLogAppender() {
        return logAppender;
    }

    public void setLogAppender(Appender logAppender) {
        this.logAppender = logAppender;
    }
}
