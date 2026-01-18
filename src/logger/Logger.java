package logger;

import logger.entity.LogLevel;
import logger.entity.LogMessage;
import logger.entity.LoggerConfig;
import logger.strategy.Appender;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger {

    private Map<String,Logger> instances = new HashMap<>();
    private LoggerConfig loggerConfig;

    private Logger(LogLevel logLevel, Appender logAppender){
        loggerConfig = new LoggerConfig(logLevel,logAppender);
    }

    public static Logger getInstance(LogLevel logLevel, Appender logAppender){
        String key = logLevel.name() + "_"+ logAppender.getClass().getName();
        return instances.computeIfAbsent(key,k-> new Logger(logLevel,logAppender));
    }

    public void setLoggerConfig(LoggerConfig loggerConfig){
        this.loggerConfig=loggerConfig;
    }

    public void log(LogLevel logLevel, String message){
        if(logLevel.getValue()>=loggerConfig.getLogLevel().getValue()){
            LogMessage logMessage = new LogMessage(message,logLevel);
            loggerConfig.getLogAppender().append(logMessage);

        }
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}
