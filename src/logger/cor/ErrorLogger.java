package logger.cor;

import logger.strategy.Appender;

public class ErrorLogger extends LogHandler{


    public ErrorLogger(int level, Appender logAppender) {
        super(level, logAppender);
    }

    @Override
    void write(String message) {
        System.out.println("ERROR: " + message);
    }
}
