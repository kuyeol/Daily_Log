package kr.sideeffect.agilejava.ch03;

import static kr.sideeffect.agilejava.ch04.ReportConstant.NEWLINE;
import kr.sideeffect.agilejava.ch01.Student;
import kr.sideeffect.agilejava.ch02.CourseSession;
import kr.sideeffect.agilejava.ch06.Session;

public class RosterReporter {
	static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-" + NEWLINE;
	static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";
	
	private Session session;
	
	RosterReporter(Session session) {
		this.session = session;
	}

	public String getReport() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append(ROSTER_REPORT_HEADER);
		
		for (Student student: session.getAllStudents()) {
			buffer.append(student.getName());
			buffer.append(NEWLINE);
		}
		
		buffer.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size() + NEWLINE);
		
		return buffer.toString();
	}
}
