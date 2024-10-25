package kr.sideeffect.agilejava.ch06;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import kr.sideeffect.agilejava.ch01.Student;
import kr.sideeffect.agilejava.ch09.Course;

abstract public class Session implements Comparable<Session> {
	static final String NEWLINE = System.getProperty("line.separator");
	static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-" + NEWLINE;
	static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";
	private static int count;
	private Course course;
	private List<Student> students = new ArrayList<Student>();
	private Date startDate;
	private int numberOfCredits;
	private URL url;
	
	protected Session(Course course, Date startDate) {
		this.course = course;
		this.startDate = startDate;
	}
	
	public String getDepartment() {
		return course.getDepartment();
	}

	public String getNumber() {
		return course.getNumber();
	}

	public int getNumberOfStudents() {
		return students.size();
	}

	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
		students.add(student);
	}

	public Student get(int index) {
		return students.get(index);
	}

	public Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		int numberOfDays = getSessionLength() * 7 - 3;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

	public Date getStartDate() {
		return startDate;
	}

	public String getRosterReport() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append(ROSTER_REPORT_HEADER);
		
		for (Student student: students) {
			buffer.append(student.getName());
			buffer.append(NEWLINE);
		}
		
		buffer.append(ROSTER_REPORT_FOOTER + students.size() + NEWLINE);
		
		return buffer.toString();
	}

	public List<Student> getAllStudents() {
		return students;
	}

	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public int compareTo(Session that) {
		int compare = this.getDepartment().compareTo(that.getDepartment());
		if (compare == 0) {
			compare = this.getNumber().compareTo(that.getNumber());
		}
		return compare;
	}
	
	abstract protected int getSessionLength();

	public void setUrl(String urlString) throws MalformedURLException {
		this.url = new URL(urlString);
	}

	public URL getUrl() {
		return url;
	}
}
