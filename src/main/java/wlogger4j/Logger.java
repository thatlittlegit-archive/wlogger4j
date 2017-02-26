package wlogga4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Logger {
	public String name;
	public LoggerConfig config;
	public LoggerPrintStream stream;
	OutputStream outstream;

	public Logger(String name) {
		this.name = name;
		this.config = new LoggerConfig();
		this.stream = null;
	}

	public Logger(String name, String fileLocation) {
		Logger toBeLogger = new Logger(name, new File(fileLocation));
		this.name = toBeLogger.name;
		this.config = toBeLogger.config;
		this.stream = toBeLogger.stream;
	}

	public Logger(String name, File file) {
		this(name, file, false);
	}

	public Logger(String name, String fileLocation, boolean setSystemOut) {
		Logger toBeLogger = new Logger(name, new File(fileLocation));
		this.name = toBeLogger.name;
		this.config = toBeLogger.config;
		this.stream = toBeLogger.stream;

		if(setSystemOut == true) {
			System.setOut(this.stream);
		}
	}

	public Logger(String name, File file, boolean setSystemOut) {
		boolean errored = false;
		this.name = name;
		this.config = new LoggerConfig();
		try {
			this.stream = new LoggerPrintStream(this, file);
		} catch(FileNotFoundException e) {
			errored = true;
			getEmptyLoggerForLib().error("File " + file.getAbsolutePath() + " not found!");
		} catch(UnsupportedEncodingException e) {
			errored = true;
			Logger tempLogger = getEmptyLoggerForLib();
			tempLogger.warn("Unsupported charset in what should be preset!");
			tempLogger.warn("Please file a bug report.");
		}

		if(setSystemOut == true && errored != true) {
			System.setOut(this.stream);
		}
	}
	
	private Logger getEmptyLoggerForLib() {
		return new Logger("wlogger4j");
	}

	public void log(Level level, String message){
		if(config.allows(level)){
			if(System.out == this.stream) {
				System.out.println(
						"[" +
								LogMetadata.Date.getDay() +
								"/" +
								LogMetadata.Date.getMonth() +
								"/" +
								LogMetadata.Date.getYear() +
								"][" +
								LogMetadata.Time.get24Hour() +
								":" +
								LogMetadata.Time.getMinute() +
								":" +
								LogMetadata.Time.getSecond() +
								"][" +
								name +
								"/" +
								level +
								"] " +
								message
						);
			} else if(this.stream == null) {
				System.out.println(
						"[" +
								LogMetadata.Date.getDay() +
								"/" +
								LogMetadata.Date.getMonth() +
								"/" +
								LogMetadata.Date.getYear() +
								"][" +
								LogMetadata.Time.get24Hour() +
								":" +
								LogMetadata.Time.getMinute() +
								":" +
								LogMetadata.Time.getSecond() +
								"][" +
								name +
								"/" +
								level +
								"] " +
								message
						);
			} else {
				this.stream.output(message);
			}
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
