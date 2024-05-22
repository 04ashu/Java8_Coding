package Dev_Genius;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,25,32,10);
		List<String> namelist = Arrays.asList("Foo", "Bar", "Bar", "Bar", "Foo");
				
		//Even numbers
		List<Integer> even = list.stream().filter(s->s%2==0).collect(Collectors.toList());
		list.stream().filter(s->s%2==0).forEach(System.out::println);
		System.out.println(even);

		//numbers starting with 1
		list.stream().map(s->s+"").filter(s->s.startsWith("1")).forEach(System.out::println);
		
		//to remove the duplicates
		list.stream().distinct().forEach(System.out::println);
		
		//to find the duplicates
		list.stream().filter(n->Collections.frequency(list,n)>1).collect(Collectors.toSet()).forEach(System.out::println);
		Set<Integer> set = new HashSet();
		list.stream().filter(n->!set.add(n)).forEach(System.out::println);
		
		//find the first element form list
		list.stream().findFirst().ifPresent(System.out::println);
		
		//total number of elements in the list
		long count = list.stream().count();
		System.out.println("Count : " + count);
		
		//maximum number 
		int max = list.stream().max(Integer::compare).get();
		System.out.println("Max : " + max);
		
		//sorted
		list.stream().sorted().forEach(System.out::println);
		
		//sorted descending
		list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		
		System.out.println(java.time.LocalDate.now());
		System.out.println(java.time.LocalTime.now());
		System.out.println(java.time.LocalDateTime.now().getDayOfWeek());
		
		//cube of elements and number greater than 1200
		list.stream().map(n->n*n*n).filter(n->n>1200).forEach(System.out::println);
		
		//convert list of strings to uppercase
		namelist.stream().map(s->s.toUpperCase()).forEach(System.out::println);
		
		//count each element from the list
		Map<String,Long> countElement = namelist.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(countElement);
		
		//find the duplicate elements from the count
		Map<Integer,Long> duplicateCounts = list.stream().filter(n->Collections.frequency(list,n)>1)
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(duplicateCounts);
		
		
		
	}

}
