package student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentMap {

	public static void main(String[] args) {
		
		Map<String,List<String>> mapStudent = Student.getAllStudents().stream().filter(s->s.getGpa()>=4)
				.collect(Collectors.toMap(Student::getName, Student::getActivities));
		System.out.println(mapStudent);
		
		Stream.of("one", "two", "three", "four")
		.peek(e->System.out.println(e))
		  .filter(e -> e.length() > 3)
		  .peek(e -> System.out.println("Filtered value: " + e))
		  .map(String::toUpperCase)
		  .peek(e -> System.out.println("Mapped value: " + e))
		  .collect(Collectors.toList());
		 
	}

}
