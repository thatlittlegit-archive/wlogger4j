package wlogger4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class LoggerPrintStream extends PrintStream {
	
	public Logger sisterLogger;
	
	public LoggerPrintStream(Logger logger, File file, String charset) throws FileNotFoundException, UnsupportedEncodingException {
		super(file, charset);
		this.sisterLogger = logger;
	}
	
	public LoggerPrintStream(Logger logger, File file) throws FileNotFoundException, UnsupportedEncodingException{
		this(logger, file, "UTF-8");
	}
	
	public LoggerPrintStream(Logger logger, OutputStream out, boolean autoFlush, String encoding) throws UnsupportedEncodingException {
		super(out, autoFlush, encoding);
		this.sisterLogger = logger;
	}
	
	public LoggerPrintStream(Logger logger, OutputStream out) throws UnsupportedEncodingException {
		this(logger, out, true, "UTF-8");
	}
	
	public LoggerPrintStream(Logger logger, OutputStream out, boolean autoFlush) throws UnsupportedEncodingException {
		this(logger, out, autoFlush, "UTF-8");
	}
	
	public LoggerPrintStream(Logger logger, String fileName) throws FileNotFoundException {
		super(fileName);
		this.sisterLogger = logger;
	}
	
	public LoggerPrintStream(Logger logger, String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
		super(fileName, csn);
		this.sisterLogger = logger;
	}
	
	public void output(Level level, String s) {
		// TODO Add prefix constructor class
		String toPrint = "[" +
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
				level +
				"] " +
				s;
		println(toPrint);
	}
	
	
	public void output(boolean b) {
		output(new Boolean(b).toString());
	}
	
	
	public void output(char c) {
		output(new Character(c).toString());
	}
	
	
	public void output(char[] cs) {
		String s = "";
		for(char c : cs) {
			s += new Character(c).toString();
		}
		output(s);
	}
	
	
	public void output(double d) {
		output(new Double(d).toString());
	}
	
	
	public void output(float f) {
		output(new Float(f).toString());
	}
	
	
	public void output(int i) {
		output(new Integer(i).toString());
	}
	
	
	public void output(long l) {
		output(new Long(l).toString());
	}
	
	
	public void output(Object obj) {
		output(obj.toString());
	}
}
