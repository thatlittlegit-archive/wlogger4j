package wlogga4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class LoggerPrintStream extends PrintStream {
	
	public Logger sisterLogger;

	public LoggerPrintStream(Logger logger, File file) throws FileNotFoundException {
		super(file);
		this.sisterLogger = logger;
	}
	
	public LoggerPrintStream(Logger logger, File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
		super(file, csn);
		this.sisterLogger = logger;
	}
	
	public LoggerPrintStream(Logger logger, OutputStream out) {
		super(out, true);
		this.sisterLogger = logger;
	}
	
	public LoggerPrintStream(Logger logger, OutputStream out, boolean autoFlush) {
		super(out, autoFlush);
		this.sisterLogger = logger;
	}
	
	public LoggerPrintStream(Logger logger, OutputStream out, boolean autoFlush, String encoding) throws UnsupportedEncodingException {
		super(out, autoFlush, encoding);
		this.sisterLogger = logger;
	}
	
	public LoggerPrintStream(Logger logger, String fileName) throws FileNotFoundException {
		super(fileName);
		this.sisterLogger = logger;
	}
	
	public LoggerPrintStream(Logger logger, String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
		super(fileName, csn);
		this.sisterLogger = logger;
	}
	
	@Override
	public void print(String s) {
		// TODO Add prefix constructor class
		super.print(					
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
				sisterLogger.name +
				"/" +
				Level.INFO +
				"] " +
				s);
	}
	
	@Override
	public void print(boolean b) {
		print(new Boolean(b).toString());
	}
	
	@Override
	public void print(char c) {
		print(new Character(c).toString());
	}
	
	@Override
	public void print(char[] cs) {
		String s = "";
		for(char c : cs) {
			s += new Character(c).toString();
		}
		print(s);
	}
	
	@Override
	public void print(double d) {
		print(new Double(d).toString());
	}
	
	@Override
	public void print(float f) {
		print(new Float(f).toString());
	}
	
	@Override
	public void print(int i) {
		print(new Integer(i).toString());
	}
	
	@Override
	public void print(long l) {
		print(new Long(l).toString());
	}
	
	@Override
	public void print(Object obj) {
		print(obj.toString());
	}
}
