package kr.sideeffect.agilejava.ch05;

import static kr.sideeffect.agilejava.ch04.ReportConstant.NEWLINE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import kr.sideeffect.agilejava.ch02.CourseSession;
import kr.sideeffect.agilejava.ch06.Session;
import kr.sideeffect.agilejava.ch09.Course;

import org.junit.Test;

public class CourseReportTest {
	
	@Test
	public void testReport() {
		final Date date = new Date();
		CourseReport report  = new CourseReport();
		report.add(create("ENGL", "101", date));
		report.add(create("CZEC", "200", date));
		report.add(create("ITAL", "410", date));
		report.add(create("CZEC", "220", date));
		report.add(create("ITAL", "330", date));
		
		assertEquals(
				"CZEC 200" + NEWLINE + 
				"CZEC 220" + NEWLINE + 
				"ENGL 101" + NEWLINE + 
				"ITAL 330" + NEWLINE +
				"ITAL 410" + NEWLINE, 
				report.text()
		);
	}
	
	private Session create(String name, String number, Date date) {
		return CourseSession.create(new Course(name, number), date);
	}

	@Test
	public void testSortStringsInPlace() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Heller");
		list.add("Kafka");
		list.add("Camus");
		list.add("Boyle");
		java.util.Collections.sort(list);
		assertEquals("Boyle", list.get(0));
		assertEquals("Camus", list.get(1));
		assertEquals("Heller", list.get(2));
		assertEquals("Kafka", list.get(3));
	}
	
	@Test
	public void testSortStringsInNewList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Heller");
		list.add("Kafka");
		list.add("Camus");
		list.add("Boyle");
		ArrayList<String> sortedList = new ArrayList<String>(list);
		java.util.Collections.sort(sortedList);
		assertEquals("Boyle", sortedList.get(0));
		assertEquals("Camus", sortedList.get(1));
		assertEquals("Heller", sortedList.get(2));
		assertEquals("Kafka", sortedList.get(3));
		
		assertEquals("Heller", list.get(0));
		assertEquals("Kafka", list.get(1));
		assertEquals("Camus", list.get(2));
		assertEquals("Boyle", list.get(3));
	}
	
	@Test
	public void testStringCompareTo() {
		assertTrue("A".compareTo("B") < 0);
		assertEquals(0, "A".compareTo("A"));
		assertTrue("B".compareTo("A") > 0);
	}
	
	@Test
	public void testComparable() {
		final Date date = new Date();
		Session sessionA = create("CMSC", "101", date);
		Session sessionB = create("ENGL", "101", date);
		assertTrue(sessionA.compareTo(sessionB) < 0);
		assertTrue(sessionB.compareTo(sessionA) > 0);
		
		Session sessionC = create("CMSC", "101", date);
		assertEquals(0, sessionA.compareTo(sessionC));
		
		Session sessionD = create("CMSC", "210", date);
		assertTrue(sessionC.compareTo(sessionD) < 0);
		assertTrue(sessionD.compareTo(sessionC) > 0);
		
	}
}
