package javacoding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {
	
	int eid;
	String name;
	int age;
	String gender;
	double salary;
	
	public Employee(int eid, String name, int age, String gender, double salary ) {
		this.eid = eid;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;			
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
	
	



	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", age=" + age + ", gender=" + gender + ", salary=" + salary
				+ "]";
	}

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1,"Nick",25,"M",25000));
		list.add(new Employee(2,"Garima",27,"F",35000));
		list.add(new Employee(3,"Shivani",26,"F",21000));
		list.add(new Employee(4,"Ravi",29,"M",55000));
		list.add(new Employee(5,"Rani",39,"F",65000));
		
		Long maleCount = list.stream().filter(e->e.getGender().equals("M")).count();
		System.out.println("Male Count : " + maleCount);
		
		Long femaleCount = list.stream().filter(e->e.getGender().equals("F")).count();
		System.out.println("Female Count : " + femaleCount);

		double maleAverageSalary = list.stream().filter(e->e.getGender().equals("M")).mapToDouble(Employee::getSalary).average().getAsDouble();
		System.out.println("Male Average Salary : " + maleAverageSalary);
		
		double femaleAverageSalary = list.stream().filter(e->e.getGender().equals("F")).mapToDouble(Employee::getSalary).average().getAsDouble();
		System.out.println("Female Average Salary : " + femaleAverageSalary);
		
		Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println(collect);
		
		List<Employee> collect2 = list.stream().sorted((e1,e2)->(int)(e2.getSalary()-e1.getSalary())).collect(Collectors.toList());
		System.out.println(collect2);
		
	}

}
