package javacoding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee3 {
	
	int eid;
	String name;
	int age;
	String gender;
	double salary;
	boolean active;

	public Employee3() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee3(int eid, String name, int age, String gender, double salary, boolean active) {
		super();
		this.eid = eid;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.active = active;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Employee3 [eid=" + eid + ", name=" + name + ", age=" + age + ", gender=" + gender + ", salary=" + salary
				+ ", active=" + active + "]";
	}

	public static void main(String[] args) {
		List<Employee3> list = new ArrayList<>();
		list.add(new Employee3(1,"Nick",25,"M",25000,true));
		list.add(new Employee3(2,"Garima",27,"F",35000,false));
		list.add(new Employee3(3,"Shivani",26,"F",21000,true));
		list.add(new Employee3(4,"Ravi",29,"M",55000,false));
		list.add(new Employee3(5,"Rani",39,"F",65000,true));
		
		list.stream().sorted(Comparator.comparing(Employee3::getSalary)).forEach(System.out::println);
		
		list.stream().sorted(Comparator.comparing(Employee3::isActive).reversed()).forEach(System.out::println);

	}

}
