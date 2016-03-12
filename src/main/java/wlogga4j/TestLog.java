package wlogga4j;

public class TestLog {
	public static void main(String args[]){
		Logger l = new Logger("Test Logger");
		l.log(Level.TRACE, "Trace Level");
		l.log(Level.DEBUG, "Debug Level");
		l.log(Level.FINER, "Finer Level");
		l.log(Level.FINE,  "Fine Level");
		l.log(Level.INFO,  "Info Level");
		l.log(Level.WARN,  "Warn Level");
		l.log(Level.ERROR, "Error Level");
		l.log(Level.FATAL, "Fatal Level");
	}
}
