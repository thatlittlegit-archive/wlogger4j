package wlogger4j;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LoggerConfigTest {
	@Test
	public void toStringTest() {
		LoggerConfig lc = new LoggerConfig();
		lc.trace = true;
		lc.debug = false;
		lc.finer = true;
		lc.fine  = false;
		lc.info  = true;
		lc.warn  = false;
		lc.error = true;
		
		assertEquals(lc.toString(), "LoggerConfig<" + Integer.toHexString(lc.hashCode()) + "> 1010101");
	}
}
