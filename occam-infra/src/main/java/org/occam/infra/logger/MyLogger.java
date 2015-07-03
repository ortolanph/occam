package org.occam.infra.logger;

import java.io.IOException;
import java.util.logging.*;

public class MyLogger {

    static private FileHandler logFile;
    static private Formatter occamLogFormatter;

    static public void setup() throws IOException {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.ALL);
        logFile = new FileHandler("occam.log");

        occamLogFormatter = new OccamLogFormatter();

        Handler console = new ConsoleHandler();
        console.setFormatter(occamLogFormatter);
        logger.addHandler(console);

        // Create HTML Formatter
        logFile.setFormatter(occamLogFormatter);
        logger.addHandler(logFile);
    }
}
