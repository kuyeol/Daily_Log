package kr.sideeffect.agilejava.ch09;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Test;

public class CourseTest {
	private StudentDirectory dir;
	
	@Test
	public void testCreate() throws IOException {
		Course course = new Course("CMSC", "120");
		assertEquals("CMSC", course.getDepartment());
		assertEquals("120", course.getNumber());
	}
	
	@Test
	public void testEquality() {
		Course courseA = new Course("NURS", "201");
		Course courseAPrime = new Course("NURS", "201");
		assertEquals(courseA, courseAPrime);
		
		Course courseB = new Course("ARTH", "330");
		assertFalse(courseA.equals(courseB));
		
		// reflexivity
		assertEquals(courseA, courseA);
		
		// transitivity
		Course courseAPrime2 = new Course("NURS", "201");
		assertEquals(courseAPrime, courseAPrime2);
		assertEquals(courseA, courseAPrime2);
		
		// symmetry
		assertEquals(courseAPrime, courseA);
		
		// consistency
		assertEquals(courseA, courseAPrime);
		
		// comparison to null
		assertFalse(courseA.equals(null));
	}
}
