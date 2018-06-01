package wlogger4j;

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
