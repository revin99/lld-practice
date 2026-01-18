package logger.cor;

import logger.entity.LogLevel;
import logger.entity.LogMessage;
import logger.strategy.Appender;

public abstract class LogHandler {

    public static int INFO =1;
    public static int DEBUG =2;
    public static int ERROR=3;

    private int level;
    private LogHandler nextLogHandler;
    private Appender logAppender;

    public void setNextLogger(LogHandler logHandler){
        this.nextLogHandler=nextLogHandler;
    }

    public LogHandler(int level,Appender logAppender){
        this.level = level;
        this.logAppender=logAppender;
    }

    private LogLevel intToLogLevel(int level){
        switch (level){
            case 1:
                return LogLevel.INFO;
            case 2:
                return LogLevel.DEBUG;
            case 3:
                return LogLevel.ERROR;
            default:
                return LogLevel.INFO;
        }
    }

    public void logMessage(int level, String message) {
        if (this.level >= level) {
            // Convert int level to LogLevel enum
            LogLevel logLevel = intToLogLevel(level);
            LogMessage logMsg = new LogMessage(message,logLevel);
            // Use the appender to log
            if (logAppender != null)
                logAppender.append(logMsg);
            write(message);
        }
        else if (nextLogHandler != null)
            nextLogHandler.logMessage(level, message);
    }

    abstract void write(String message);
}
