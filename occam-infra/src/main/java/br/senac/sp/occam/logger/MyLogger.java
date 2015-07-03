package br.senac.sp.occam.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

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
