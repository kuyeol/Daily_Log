package kr.sideeffect.agilejava.ch05;

import static org.junit.Assert.*;
import kr.sideeffect.agilejava.ch01.Student;

import org.junit.Test;

public class HonorsGradingStrategyTest {
	@Test
	public void testGetGradePoints() throws Exception {
		GradingStrategy strategy = new HonorsGradingStrategy();
		assertEquals(5, strategy.getGradePointsFor(Student.Grade.A));
		assertEquals(4, strategy.getGradePointsFor(Student.Grade.B));
		assertEquals(3, strategy.getGradePointsFor(Student.Grade.C));
		assertEquals(2, strategy.getGradePointsFor(Student.Grade.D));
		assertEquals(0, strategy.getGradePointsFor(Student.Grade.F));
	}
}
