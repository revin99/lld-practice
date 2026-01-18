package logger.strategy;

import logger.entity.LogMessage;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements Appender{

    private String filename;
    public FileAppender(String filename){
        this.filename=filename;
    }

    @Override
    public void append(LogMessage logMessage) {

        try(FileWriter fileWriter= new FileWriter(filename,true)){
            fileWriter.write(logMessage.getMessage());
        } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }
}
