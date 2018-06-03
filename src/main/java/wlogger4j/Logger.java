package wlogger4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Logger {
	public String name;
	public LoggerConfig config;
	public LoggerPrintStream stream;

	public Logger(String name) throws UnsupportedEncodingException {
		this.name = name;
		this.config = new LoggerConfig();
		this.stream = new LoggerPrintStream(name, System.out);
	}

	public Logger(String name, String fileLocation) throws UnsupportedEncodingException, IOException {
		Logger toBeLogger = new Logger(name, new File(fileLocation));
		this.name = toBeLogger.name;
		this.config = toBeLogger.config;
		this.stream = toBeLogger.stream;
	}

	public Logger(String name, File file) throws UnsupportedEncodingException, IOException {
		this.name = name;
		this.config = new LoggerConfig();
		try {
			this.stream = new LoggerPrintStream(name, file);
		} catch(FileNotFoundException e) {
			file.createNewFile();
			this.stream = new Logger(name, file).stream; // HACK replace constructor call
		}
	}

	public void log(Level level, String message){
		if(config.allows(level)){
			this.stream.output(level, message);
		}
	}

	public void trace(String message){
		log(Level.TRACE, message);
	}
	public void debug(String message){
		log(Level.DEBUG, message);
	}
	public void finer(String message){
		log(Level.FINER, message);
	}
	public void fine(String message){
		log(Level.FINE, message);
	}
	public void info(String message){
		log(Level.INFO, message);
	}
	public void warn(String message){
		log(Level.WARN, message);
	}
	public void error(String message){
		log(Level.ERROR, message);
	}
	public void fatal(String message){
		log(Level.FATAL, message);
	}
}
