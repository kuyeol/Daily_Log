package kr.sideeffect.agilejava.ch09;

public class Course {
	private String department;
	private String number;
	
	public Course(String department, String number) {
		this.department = department;
		this.number = number;
	}

	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		Course that = (Course)object;
		return this.department.equals(that.department) && this.number.equals(that.number);
	}
}
