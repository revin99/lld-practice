package logger.strategy;

import logger.entity.LogMessage;

public interface Appender {

    void append(LogMessage logMessage);
}
