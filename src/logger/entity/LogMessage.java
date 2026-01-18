package logger.entity;

import java.util.Date;

public class LogMessage {

    private Date timestamp;
    private String Message;
    private LogLevel logLevel;

    public LogMessage(String message, LogLevel logLevel) {
        this.timestamp = new Date();
        Message = message;
        this.logLevel = logLevel;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
