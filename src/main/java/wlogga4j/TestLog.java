package wlogga4j;

public class TestLog {
	public static void main(String args[]){
		Logger l = new Logger("Test Logger 1");
		l.log(Level.TRACE, "Trace Level");
		l.log(Level.DEBUG, "Debug Level");
		l.log(Level.FINER, "Finer Level");
		l.log(Level.FINE,  "Fine Level");
		l.log(Level.INFO,  "Info Level");
		l.log(Level.WARN,  "Warn Level");
		l.log(Level.ERROR, "Error Level");
		l.log(Level.FATAL, "Fatal Level");
		
		Logger l1 = new Logger("Test Logger 2", "test.log");
		l1.log(Level.TRACE, "Trace Level");
		l1.log(Level.DEBUG, "Debug Level");
		l1.log(Level.FINER, "Finer Level");
		l1.log(Level.FINE,  "Fine Level");
		l1.log(Level.INFO,  "Info Level");
		l1.log(Level.WARN,  "Warn Level");
		l1.log(Level.ERROR, "Error Level");
		l1.log(Level.FATAL, "Fatal Level");
	}
}
