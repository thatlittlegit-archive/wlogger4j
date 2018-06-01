package wlogger4j;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LoggerTest {
	private static int countLinesInScanner(Scanner scanner) {
		int counter = 0;
		while(true) {
			try {
				scanner.nextLine();
				counter += 1;
			} catch (NoSuchElementException e) {
				 break;
			}
		}
		scanner.close();
		return counter;
	}
	
	private static void loggerDummyInput(Logger l) {
		l.log(Level.TRACE, "Trace Level");
		l.log(Level.DEBUG, "Debug Level");
		l.log(Level.FINER, "Finer Level");
		l.log(Level.FINE,  "Fine Level");
		l.log(Level.INFO,  "Info Level");
		l.log(Level.WARN,  "Warn Level");
		l.log(Level.ERROR, "Error Level");
		l.log(Level.FATAL, "Fatal Level");	
	}

	@Test
	public void outputToStandardOut() {
		Logger l = new Logger("test");
		assertSame(l.stream, System.out);
	}

	@Test
	public void outputToFileName() throws UnsupportedEncodingException, IOException {
		Logger l = new Logger("test", "test.log");
		assertNotEquals(l.stream, System.out);
		loggerDummyInput(l);

		File testLogFile = new File("test.log");
		assertTrue(testLogFile.exists());
		
		assertEquals(countLinesInScanner(new Scanner(testLogFile)), 4);
		
		testLogFile.delete(); // clean up
	}
	
	@Test
	public void outputToFile() throws UnsupportedEncodingException, IOException {
		File testLogFile = new File("test.log");
		Logger l = new Logger("test", testLogFile);
		loggerDummyInput(l);
		
		assertTrue(testLogFile.exists());
		
		assertEquals(countLinesInScanner(new Scanner(testLogFile)), 4);
		
		testLogFile.delete(); // clean up
	}
}
