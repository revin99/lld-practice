package logger.strategy;

import logger.entity.LogMessage;

public class ConsoleAppender implements Appender{
    @Override
    public void append(LogMessage logMessage) {
        System.out.println("Appending to console");
        System.out.println(logMessage.getMessage());
    }
}
