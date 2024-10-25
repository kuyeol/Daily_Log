package kr.sideeffect.agilejava.ch08;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScorerTest {
	@Test
	public void testCaptureScore() throws Exception {
		Scorer scorer = new Scorer();
		assertEquals(75, scorer.score("75"));
	}
	
	@Test(expected=NumberFormatException.class)
	public void testbadScoreEntered() {
		Scorer scorer = new Scorer();
		scorer.score("abd");
	}
	
	@Test
	public void testIsValid() throws Exception {
		Scorer scorer = new Scorer();
		assertTrue(scorer.isValid("75"));
		assertFalse(scorer.isValid("bd"));
	}
}
