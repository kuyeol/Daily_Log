package kr.sideeffect.agilejava.ch05;

import kr.sideeffect.agilejava.ch01.Student.Grade;

public class BasicGradingStrategy implements GradingStrategy {
	public int getGradePointsFor(Grade grade) {
		return grade.getPoints();
	}
}
