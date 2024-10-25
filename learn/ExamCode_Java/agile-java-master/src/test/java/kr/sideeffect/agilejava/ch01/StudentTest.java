package kr.sideeffect.agilejava.ch01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.logging.Handler;
import java.util.logging.Logger;

import kr.sideeffect.agilejava.ch08.StudentNameFormatException;
import kr.sideeffect.agilejava.ch08.TestHandler;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StudentTest {
	private static final double GRADE_TOLERANCE = 0.05;
	
	@Test
	public void testCreate() {
		final String firstStudentName = "Jane Doe";
		Student firstStudent = new Student(firstStudentName);
		assertEquals(firstStudentName, firstStudent.getName());
		assertEquals("Jane", firstStudent.getFirstName());
		assertEquals("Doe", firstStudent.getLastName());
		assertEquals("", firstStudent.getMiddleName());

		final String secondStudentName = "Blow";
		Student secondStudent = new Student(secondStudentName);
		assertEquals(secondStudentName, secondStudent.getName());
		assertEquals("", secondStudent.getFirstName());
		assertEquals("Blow", secondStudent.getLastName());
		assertEquals("", secondStudent.getMiddleName());
		
		final String thirdStudentName = "Raymond Douglas Davies";
		Student thirdStudent = new Student(thirdStudentName);
		assertEquals(thirdStudentName, thirdStudent.getName());
		assertEquals("Raymond", thirdStudent.getFirstName());
		assertEquals("Davies", thirdStudent.getLastName());
		assertEquals("Douglas", thirdStudent.getMiddleName());
	}
	
	@Test
	public void testStudentStatus() {
		Student student = new Student("a");
		assertEquals(0, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(3);
		assertEquals(3, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(4);
		assertEquals(7, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(5);
		assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
		assertTrue(student.isFullTime());
	}
	
	@Test
	public void testInState() {
		Student student = new Student("a");
		assertFalse(student.isInState());
		student.setState(Student.IN_STATE);
		assertTrue(student.isInState());
		student.setState("MD");
		assertFalse(student.isInState());
	}
	
	@Test
	public void testCalculateGpa() {
		Student student = new Student("a");
		assertGpa(student, 0.0);
		student.addGrade(Student.Grade.A);
		assertGpa(student, 4.0);
		student.addGrade(Student.Grade.B);
		assertGpa(student, 3.5);
		student.addGrade(Student.Grade.C);
		assertGpa(student, 3.0);
		student.addGrade(Student.Grade.D);
		assertGpa(student, 2.5);
		student.addGrade(Student.Grade.F);
		assertGpa(student, 2.0);
	}
	
	private void assertGpa(Student student, double expectedGpa) {
		assertEquals(expectedGpa, student.getGpa(), GRADE_TOLERANCE);
	}
	
	@Test
	public void testCalculateHonorsStudentGpa() {
		Student student = new Student("a");
		assertGpa(student.createHonorsStudent(), 0.0);
		assertGpa(student.createHonorsStudent(Student.Grade.A), 5.0);
		assertGpa(student.createHonorsStudent(Student.Grade.B), 4.0);
		assertGpa(student.createHonorsStudent(Student.Grade.C), 3.0);
		assertGpa(student.createHonorsStudent(Student.Grade.D), 2.0);
		assertGpa(student.createHonorsStudent(Student.Grade.F), 0.0);
	}
	
	@Rule
	public ExpectedException expectedExcetption = ExpectedException.none();
	
	@Test
	public void testBadlyFormattedName() {
		Handler handler = new TestHandler();
		Student.logger.addHandler(handler);
		final String studentName = "a b c d";
		String message = String.format(Student.TOO_MANY_NAME_PARTS_MSG, studentName, Student.MAX_NAME_PARTS);
		
		expectedExcetption.expect(StudentNameFormatException.class);
		expectedExcetption.expectMessage(message);
		new Student(studentName);
		
		assertEquals(message, ((TestHandler)handler).getMessage());
	}
}
