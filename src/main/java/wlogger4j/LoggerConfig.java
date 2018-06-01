package wlogger4j;

public class LoggerConfig {
	public boolean trace = false;
	public boolean debug = false;
	public boolean finer = false;
	public boolean fine  = false;
	public boolean info  = true;
	public boolean warn  = true;
	public boolean error = true;
	public boolean fatal = true;
	
	public boolean showStreams = true;

	public boolean allows(Level l) {
		switch(l) {
		case TRACE:
			return trace;
		case DEBUG:
			return debug;
		case FINER:
			return finer;
		case FINE :
			return fine ;
		case INFO :
			return info;
		case WARN :
			return warn;
		case ERROR :
			return error;
		case FATAL :
			return fatal;
		default    :
			return l.config(l, this);
		
		}
	}
}
