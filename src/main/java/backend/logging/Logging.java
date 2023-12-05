package backend.logging;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class Logging {
    static Logger logger = Logger.getLogger(Logging.class.getName());

    public static void main(String[] args){
        logger.setLevel(Level.ALL);
       // logger.addHandler(new ConsoleHandler());
        try {
            FileHandler fileHandler = new FileHandler("src/main/java/backend/logging/logger.log",2000, 5);
            Formatter formatter = new Formatter() {
                @Override
                public String format(LogRecord record) {
                    return record.getThreadID()+"::"+record.getSourceClassName()+"::"
                            +record.getSourceMethodName()+"::"
                            +new Date(record.getMillis())+"::"
                            +record.getMessage()+"\n";
                }
            };
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
            logger.log(Level.INFO, "Das sollte die erste Zeile im Log sein");
        } catch (IOException e) {
            logger.log(Level.SEVERE,e.toString());
            throw new RuntimeException(e);
        }
    }

}
