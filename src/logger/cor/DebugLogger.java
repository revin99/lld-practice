package logger.cor;

import logger.strategy.Appender;

public class DebugLogger extends LogHandler{
    public DebugLogger(int level, Appender logAppender) {
        super(level, logAppender);
    }

    @Override
    void write(String message) {
        System.out.println("DEBUG: " + message);
    }
}
