package kr.sideeffect.agilejava.ch03;

import static kr.sideeffect.agilejava.ch04.ReportConstant.NEWLINE;
import static org.junit.Assert.assertEquals;
import kr.sideeffect.agilejava.ch01.Student;
import kr.sideeffect.agilejava.ch02.CourseSession;
import kr.sideeffect.agilejava.ch06.Session;
import kr.sideeffect.agilejava.ch09.Course;

import org.junit.Test;

public class RosterReporterTest {
	@Test
	public void testRosterReport() {
		Session session = CourseSession.create(new Course("ENGL", "101"), DateUtil.createDate(2003, 1, 6));
		
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		
		String rosterReport = new RosterReporter(session).getReport();

		assertEquals(RosterReporter.ROSTER_REPORT_HEADER + "A" + NEWLINE + "B" + NEWLINE + RosterReporter.ROSTER_REPORT_FOOTER + "2" + NEWLINE, rosterReport);
	}
}
