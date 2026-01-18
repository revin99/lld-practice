package logger;

import logger.cor.DebugLogger;
import logger.cor.ErrorLogger;
import logger.cor.InfoLogger;
import logger.cor.LogHandler;
import logger.entity.LogLevel;
import logger.entity.LoggerConfig;
import logger.strategy.Appender;
import logger.strategy.ConsoleAppender;
import logger.strategy.FileAppender;

// Client class to demonstrate logging system
public class Main {
    // Build the chain of loggers: INFO -> DEBUG -> ERROR
    private static LogHandler getChainOfLoggers(Appender appender) {
        LogHandler errorLogger = new ErrorLogger(LogHandler.ERROR, appender);
        LogHandler debugLogger = new DebugLogger(LogHandler.DEBUG, appender);
        LogHandler infoLogger = new InfoLogger(LogHandler.INFO, appender);
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);
        return infoLogger;
    }

    public static void main(String[] args) {
        // Select the log appender (console or file)
        Appender consoleAppender = new ConsoleAppender();
        Appender fileAppender = new FileAppender("logs.txt");
        // Create the chain of loggers with the console appender
        LogHandler loggerChain = getChainOfLoggers(consoleAppender);

        // Use a single logging approach to avoid duplication
        System.out.println("Logging INFO level message:");
        loggerChain.logMessage(LogHandler.INFO, "This is an information.");
        System.out.println("nLogging DEBUG level message:");
        loggerChain.logMessage(LogHandler.DEBUG, "This is a debug level information.");
        System.out.println("nLogging ERROR level message:");
        loggerChain.logMessage(LogHandler.ERROR, "This is an error information.");

        // Demonstrate the singleton Logger usage as an alternative
        System.out.println("nUsing Singleton Logger:");
        Logger logger = Logger.getInstance(LogLevel.INFO, consoleAppender);
        logger.setLoggerConfig(new LoggerConfig(LogLevel.INFO, fileAppender));
        logger.error("Using singleton Logger - Error message");
    }
}