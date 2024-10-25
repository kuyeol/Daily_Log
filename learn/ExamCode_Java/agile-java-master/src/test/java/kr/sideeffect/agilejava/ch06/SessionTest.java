package kr.sideeffect.agilejava.ch06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.Date;

import kr.sideeffect.agilejava.ch01.Student;
import kr.sideeffect.agilejava.ch03.DateUtil;
import kr.sideeffect.agilejava.ch09.Course;

import org.junit.Before;
import org.junit.Test;

public abstract class SessionTest {
	private Session session;
	private Date startDate;
	private static final int CREDITS = 3;
	
	@Before
	public void setUp() {
		startDate = DateUtil.createDate(2003, 1, 6);
		session = createSession(new Course("ENGL", "101"), startDate);
		session.setNumberOfCredits(CREDITS);
	}
	
	abstract protected Session createSession (Course course, Date startDate);
	
	@Test
	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
	}
	
	@Test
	public void testEnrollStudents() {
		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(CREDITS, student1.getCredits());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		
		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(CREDITS, student2.getCredits());
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}
	
	@Test
	public void testComparable() {
		final Date date = new Date();
		Session sessionA = createSession(new Course("CMSC", "101"), date);
		Session sessionB = createSession(new Course("ENGL", "101"), date);
		assertTrue(sessionA.compareTo(sessionB) < 0);
		assertTrue(sessionB.compareTo(sessionA) > 0);
		
		Session sessionC = createSession(new Course("CMSC", "101"), date);
		assertEquals(0, sessionA.compareTo(sessionC));
		
		Session sessionD = createSession(new Course("CMSC", "210"), date);
		assertTrue(sessionC.compareTo(sessionD) < 0);
		assertTrue(sessionD.compareTo(sessionC) > 0);
	}
	
	@Test
	public void testSessionUrl() throws MalformedURLException {
		final String url = "http://course.langrsoft.com/cmsc300";
		session.setUrl(url);
		assertEquals(url, session.getUrl().toString());
	}
	
	@Test(expected=MalformedURLException.class)
	public void testInvalidSessionUrl() throws Exception {
		final String url = "httsp://course.langrsoft.com/cmsc300";
		session.setUrl(url);
	}
}
