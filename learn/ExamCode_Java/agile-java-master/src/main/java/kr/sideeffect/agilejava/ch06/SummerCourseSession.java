package kr.sideeffect.agilejava.ch06;

import java.util.Date;

import kr.sideeffect.agilejava.ch09.Course;

public class SummerCourseSession extends Session {
	private SummerCourseSession(Course course, Date startDate) {
		super(course, startDate);
	}
	
	public static Session create(Course course, Date startDate) {
		return new SummerCourseSession(course, startDate);
	}
	
	@Override
	protected int getSessionLength() {
		return 8;
	}
	
}
