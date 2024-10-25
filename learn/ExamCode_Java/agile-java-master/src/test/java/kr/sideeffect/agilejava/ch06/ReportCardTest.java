package kr.sideeffect.agilejava.ch06;

import static org.junit.Assert.*;
import kr.sideeffect.agilejava.ch01.Student;

import org.junit.Test;


public class ReportCardTest {
	@Test
	public void testMessage() throws Exception {
		ReportCard card = new ReportCard();
		assertEquals(ReportCard.A_MESSAGE, card.getMessage(Student.Grade.A));
		assertEquals(ReportCard.B_MESSAGE, card.getMessage(Student.Grade.B));
		assertEquals(ReportCard.C_MESSAGE, card.getMessage(Student.Grade.C));
		assertEquals(ReportCard.D_MESSAGE, card.getMessage(Student.Grade.D));
		assertEquals(ReportCard.F_MESSAGE, card.getMessage(Student.Grade.F));
	}
}
