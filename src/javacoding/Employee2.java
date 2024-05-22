package javacoding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Employee2 {
	
	private String name;
	private String department;
	private double salary;

	public Employee2(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}

	public static void main(String[] args) {
		
		List<Employee2> list = new ArrayList<Employee2>();
		list.add(new Employee2("John", "HR", 50000));
		list.add(new Employee2("Alice", "Finance", 60000));
		list.add(new Employee2("Bob", "IT", 70000));
		list.add(new Employee2("Emily", "HR", 55000));
		list.add(new Employee2("David", "IT", 75000));
		
		Map<String,List<Employee2>> employeesByDepartment = list.stream().collect(Collectors.groupingBy(Employee2::getDepartment));
		
		Map<String, Employee2> highestPaidEmployees = new HashMap<>();
		employeesByDepartment.forEach((department,emplist) -> {
			Optional<Employee2> highestPaidEmployee =  emplist.stream().max(Comparator.comparingDouble(Employee2::getSalary));
			highestPaidEmployee.ifPresent(employee -> highestPaidEmployees.put(department, employee));
		});
		
		highestPaidEmployees.forEach((department,employee) -> {
			System.out.println("Department : " + department + "---Highest Paid Employee : " + employee.getName());
		});
		
		
		Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Employee2::getDepartment,Collectors.counting()));
		System.out.println(collect); 
		
	}

}
