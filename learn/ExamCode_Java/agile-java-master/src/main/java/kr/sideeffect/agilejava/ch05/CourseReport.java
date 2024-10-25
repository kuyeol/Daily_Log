package kr.sideeffect.agilejava.ch05;

import static kr.sideeffect.agilejava.ch04.ReportConstant.NEWLINE;

import java.util.ArrayList;
import java.util.Collections;

import kr.sideeffect.agilejava.ch02.CourseSession;
import kr.sideeffect.agilejava.ch06.Session;

public class CourseReport {
	private ArrayList<Session> sessions = new ArrayList<Session>();
	
	public void add(Session session) {
		sessions.add(session);
	}

	public String text() {
		Collections.sort(sessions);
		StringBuilder builder = new StringBuilder();
		for (Session session: sessions) {
			builder.append(session.getDepartment() + " " + session.getNumber() + NEWLINE);
		}
		return builder.toString();
	}
}
