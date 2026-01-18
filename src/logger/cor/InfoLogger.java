package logger.cor;

import logger.strategy.Appender;

public class InfoLogger extends LogHandler{
    public InfoLogger(int level, Appender logAppender) {
        super(level, logAppender);
    }

    @Override
    void write(String message) {
        System.out.println("INFO: " + message);
    }
}
