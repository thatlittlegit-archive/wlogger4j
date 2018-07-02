package wlogger4j;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class LoggerConfigTest {
	private LoggerConfig templateConfig() {
		LoggerConfig lc = new LoggerConfig();
		lc.trace = true;
		lc.debug = false;
		lc.finer = true;
		lc.fine  = false;
		lc.info  = true;
		lc.warn  = false;
		lc.error = true;
		
		return lc;
	}

	@Test
	public void allowsTest( ) {
		LoggerConfig lc = templateConfig();
		assertTrue (lc.allows(Logger.Level.TRACE));
		assertFalse(lc.allows(Logger.Level.DEBUG));
		assertTrue (lc.allows(Logger.Level.FINER));
		assertFalse(lc.allows(Logger.Level.FINE ));
		assertTrue (lc.allows(Logger.Level.INFO ));
		assertFalse(lc.allows(Logger.Level.WARN ));
		assertTrue (lc.allows(Logger.Level.ERROR));
	}
	@Test
	public void toStringTest() {
		LoggerConfig lc = templateConfig();
		assertEquals(lc.toString(), "LoggerConfig<" + Integer.toHexString(lc.hashCode()) + "> 1010101");
	}
}
