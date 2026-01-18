package logger.entity;

public enum LogLevel {
    INFO(1),
    DEBUG(2),
    ERROR(3);

    private int value;

    public int getValue(){
        return this.value;
    }

    LogLevel(int value) {
        this.value=value;
    }
}
