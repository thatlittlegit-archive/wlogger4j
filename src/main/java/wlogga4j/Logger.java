package wlogga4j;

public class Logger {
	private String name;
	private LoggerConfig config;

	public Logger(String name) {
		this.name = name;
		this.config = new LoggerConfig();
		// TODO Set System.out to a custom PrintStream
	}

	public void log(Level level, String message){
		if(config.allows(level)){
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
