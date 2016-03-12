package wlogga4j;

import java.util.Calendar;

public class LogMetadata {
	private String name;
	
	private static Calendar calendar = Calendar.getInstance();
	
	public String getName() {
		return name;
	}
	static class Time {
		public static int get12Hour() {
			return calendar.get(Calendar.HOUR);
		}
		public static int get24Hour() {
			return calendar.get(Calendar.HOUR_OF_DAY);
		}
		public static int getMinute() {
			return calendar.get(Calendar.MINUTE);
		}
		public static int getSecond() {
			return calendar.get(Calendar.SECOND);
		}
	}
	static class Date {
		public static int getDay() {
			return calendar.get(Calendar.DAY_OF_MONTH);
		}
		public static int getMonth() {
			return calendar.get(Calendar.MONTH) + 1;
		}
		public static int getYear() {
			return calendar.get(Calendar.YEAR);
		}
	}
}
