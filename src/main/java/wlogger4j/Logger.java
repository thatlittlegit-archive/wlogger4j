package wlogger4j;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.ZoneOffset;

public class Logger {
	public String name;
	public LoggerConfig config;
	public OutputStream stream;
	public Runnable onIOException = null;
	public static String loggerFormat = "[!ISOD][!ISOT:!SECOND][!NAME][!LEVEL] !MESSAGE";

	public Logger(String name) throws UnsupportedEncodingException {
		this(name, System.out);
	}

	public Logger(String name, String fileLocation) throws UnsupportedEncodingException, IOException {
		this(name, new File(fileLocation));
	}

	public Logger(String name, File file) throws UnsupportedEncodingException, IOException {
		this(name, new PrintStream(file));
	}
	
	public Logger(String name, OutputStream stream) {
		this(name, stream, null);
	}
	
	public Logger(String name, OutputStream stream, Runnable onIOException) {
		this(name, new LoggerConfig(), stream, onIOException);
	}
	
	public Logger(String name, LoggerConfig config, OutputStream stream, Runnable onIOException) {
		this.name = name;
		this.config = config;
		this.stream = stream;
		this.onIOException = onIOException;
	}
	
	private String formatDateTime(String pattern) {
		return java.time.format.DateTimeFormatter.ofPattern(pattern)
                .withZone(ZoneOffset.systemDefault())
                .format(Instant.now());
	}

	public void log(Level level, String message) {
		if(config.allows(level)){
			try {
				this.stream.write((loggerFormat + "\n")
						// https://stackoverflow.com/a/3914546
						.replaceAll("!ISOD", formatDateTime("yyyy-MM-dd"))
						.replaceAll("!ISOT", formatDateTime("HH:mm"))
						.replaceAll("!HOUR", formatDateTime("HH"))
						.replaceAll("!MINUTE", formatDateTime("mm"))
						.replaceAll("!SECOND", formatDateTime("ss"))
						.replaceAll("!YEAR", formatDateTime("yyyy"))
						.replaceAll("!MONTH", formatDateTime("MM"))
						.replaceAll("!DAY", formatDateTime("dd"))
						.replaceAll("!NAME",  this.name)
						.replaceAll("!LEVEL", level.toString())
						.replaceAll("!MESSAGE", message).getBytes());
			} catch (IOException e) {
				if (onIOException == null) {
					e.printStackTrace();
					System.exit(120);
				} else {
					onIOException.run();
				}
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
	
	public enum Level {
		TRACE,
		DEBUG,
		FINE,
		FINER,
		INFO,
		WARN,
		ERROR,
		FATAL;
		
		public boolean config(Level l, LoggerConfig lc) {
			return lc.allows(l);
		}
	}
}
