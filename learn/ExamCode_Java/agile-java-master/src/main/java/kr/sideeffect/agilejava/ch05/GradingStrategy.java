package kr.sideeffect.agilejava.ch05;

import kr.sideeffect.agilejava.ch01.Student;

public interface GradingStrategy {
	public int getGradePointsFor(Student.Grade grade);
}
