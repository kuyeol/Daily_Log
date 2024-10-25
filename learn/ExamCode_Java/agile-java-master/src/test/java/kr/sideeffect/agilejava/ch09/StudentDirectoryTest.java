package kr.sideeffect.agilejava.ch09;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import kr.sideeffect.agilejava.ch01.Student;

import org.junit.Before;
import org.junit.Test;

public class StudentDirectoryTest {
	private StudentDirectory dir;
	
	@Before
	public void setUp() {
		dir = new StudentDirectory();
	}
	
	@Test
	public void testStoreAndRetrieve() throws IOException {
		final int numberOfStudents = 10;
		
		for (int i = 0; i < numberOfStudents; i++) {
			addStudent(dir, i);
		}
		
		for (int i = 0; i < numberOfStudents; i++) {
			verifyStudentLookup(dir, i);
		}
	}

	private void addStudent(StudentDirectory directory, int i) throws IOException {
		String id = "" + i;
		Student student = new Student(id);
		student.setId(id);
		student.addCredits(i);
		directory.add(student);
	}
	
	private void verifyStudentLookup(StudentDirectory directory, int i) throws IOException {
		String id = "" + i;
		Student student = dir.findById(id);
		assertEquals(id, student.getLastName());
		assertEquals(id, student.getId());
		assertEquals(i, student.getCredits());
	}
}
