package kr.sideeffect.agilejava.ch03;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class DateUtilTest {
	@Test
	public void testCreateDate() {
		Date date = DateUtil.createDate(2000, 1, 1);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		assertEquals(2000, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
		assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
	}
}
