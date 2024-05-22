package student;

import java.util.Arrays;
import java.util.List;

public class Student {
	
	String name;
	int gradeLevel;
	double gpa;
	String gender;
	List<String> activities;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int gradeLevel, double gpa, String gender, List<String> activities) {
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.gender = gender;
		this.activities = activities;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGradeLevel() {
		return gradeLevel;
	}
	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getActivities() {
		return activities;
	}
	public void setActivities(List<String> activities) {
		this.activities = activities;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", gradeLevel=" + gradeLevel + ", gpa=" + gpa + ", gender=" + gender
				+ ", activities=" + activities + "]";
	}
	
	public static List<Student> getAllStudents(){
		
		Student s1 = new Student("Adam",2,3.6,"male",Arrays.asList("swimming","coding","cricket"));
		Student s2 = new Student("Jenny",2,3.8,"female",Arrays.asList("swimming","gymnamstics","volleyball"));
		
		Student s3 = new Student("Emily",3,4.0,"female",Arrays.asList("dancing","gymnastics","aerobics"));
		Student s4 = new Student("Dave",3,3.9,"male",Arrays.asList("soccer","basketball","baseball"));
		
		Student s5 = new Student("Sophia",4,3.5,"female",Arrays.asList("swimming","dancing","football"));
		Student s6 = new Student("James",4,3.9,"male",Arrays.asList("swimming","coding","baseball"));
		
		List<Student> studentList = Arrays.asList(s1,s2,s3,s4,s5,s6);
		return studentList;
		
	}
	

}
