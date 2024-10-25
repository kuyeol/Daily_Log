package kr.sideeffect.agilejava.ch02;

import java.util.Date;

import kr.sideeffect.agilejava.ch06.Session;
import kr.sideeffect.agilejava.ch09.Course;

public class CourseSession extends Session {
	private static int count;
	
	protected CourseSession(Course course, Date startDate) {
		super(course, startDate);
		CourseSession.incrementCount();
	}
	
	public static void resetCount() {
		count = 0;
	}
	
	private static void incrementCount() {
		++count;
	}

	public static int getCount() {
		return count;
	}
	
	public static Session create(Course course, Date startDate) {
		return new CourseSession(course, startDate);
	}
	
	@Override
	protected int getSessionLength() {
		return 16;
	}

}
