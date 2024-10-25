package kr.sideeffect.agilejava.ch05;

import kr.sideeffect.agilejava.ch01.Student.Grade;

public class HonorsGradingStrategy extends BasicGradingStrategy {
	@Override
	public int getGradePointsFor(Grade grade) {
		int points = super.getGradePointsFor(grade);
		if (points > 0) {
			points += 1;
		}
		return points;
	}

}
