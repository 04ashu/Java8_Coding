package repeat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Repeat4 {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,25,32,10);
		
		//Even numbers from the list
		System.out.println("Even nuimbers");
		list.stream().filter(n->n%2==0).forEach(System.out::println);
		
		//Numbers starting with '1'
		System.out.println("Numbers starting with '1'");
		list.stream().map(s->s+"").filter(s->s.startsWith("1")).forEach(System.out::println);
		
		//To remove duplicates
		System.out.println("To remove duplicates");
		list.stream().distinct().forEach(System.out::println);
		
		//To find the duplicates
		System.out.println("Find the duplicates");
		list.stream().filter(n->Collections.frequency(list, n)>1).collect(Collectors.toSet()).forEach(System.out::println);
		
		System.out.println("Duplicates with the help of Set");
		Set<Integer> set =  new HashSet(); 
		list.stream().filter(n->!set.add(n)).forEach(System.out::println);
		
		//find the first element from the list
		System.out.println("Find the first element from the list");
		int first = list.stream().findFirst().get();
		System.out.println(first);
		
		//total number of elements in the list
		System.out.println("Total number of elements in the list");
		Long count = list.stream().count();
		System.out.println(count);
		
		//maximum and minimum number of the list
		System.out.println("Maximum");
		int max = list.stream().max(Comparator.naturalOrder()).get();
		System.out.println(max);
		
		System.out.println("Minimum");
		int min = list.stream().min(Integer::compare).get();
		System.out.println(min);
		
		//sorting
		System.out.println("Sorting in natural order");
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println("Sorting in descending order");
		list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		
		//Cube of elements and number greater than 1200
		System.out.println("Cube of elements and number greater than 1200");
		list.stream().map(n->n*n*n).filter(n->n>1200).forEach(System.out::println);
		
		//Convert the list of strings to uppercase
		System.out.println("Convert the list of strings to uppercase");
		List<String> strList = Arrays.asList("chotu","totu","small","verysmall");
		strList.stream().map(String::toUpperCase).forEach(System.out::println);
		
		//Count each element of the list
		System.out.println("Count each element of the list");
		Map<Integer,Long> countElement = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(countElement);
		
		//find the duplicate elements count
		System.out.println("Duplicate element count");
		Map<Integer,Long> countDuplicate = list.stream().filter(n->Collections.frequency(list, n)>1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(countDuplicate);
		
		//Multiples of 5 from the list
		System.out.println("Multiples of 5 from the list");
		list.stream().filter(n->n%5==0).forEach(System.out::println);
		
		//Three max and min numbers from the list
		System.out.println("Three max numbers from the list");
		list.stream().sorted(Collections.reverseOrder()).limit(3).forEach(System.out::println);
		
		System.out.println("Three min numbers from the list"); 
		list.stream().distinct().sorted().limit(3).forEach(System.out::println);
		
		//Sum and Average of all numbers in the array
		System.out.println("Sum of all numbers in the array");
		int arr[] = new int[] {10,15,8,49,25,98,25,32,10};
		int sumArray = Arrays.stream(arr).sum();
		System.out.println(sumArray);
		
		System.out.println("Avergae of all numbers in the array");
		double averageArray = Arrays.stream(arr).average().getAsDouble();
		System.out.println(averageArray);
		
		//Sum and average of all numbers in the list
		System.out.println("Sum of all numbers in the list");
		int sumList = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sumList);
		
		System.out.println("Average of all numbers in the list");
		double averageList = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(averageList);
		
		//Last element of the list
		System.out.println("Last element of the list");
		int last = list.stream().skip(list.size()-1).findFirst().get();
		System.out.println(last);
		
		//Second largest number of the list
		System.out.println("Second largest number of the list");
		int secMax = list.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
		System.out.println(secMax);
		
		//First 10 even numbers
		System.out.println("First 10 even numbers");
		IntStream.range(1, 21).filter(n->n%2==0).forEach(System.out::println);
		
		//Join the list of strings with prefix, suffix and delimiter
		System.out.println("Join the list of strings with prefix, suffix and delimiter");
		List<String> stringList = Arrays.asList("HTML","Kotlin","C#","Java","Python","C++","Cobol","C");
		String outputString = stringList.stream().collect(Collectors.joining(",","{", "}"));
		System.out.println(outputString);
		
		//Concatenation of two arrays in sorted order without duplicate elements
		System.out.println("Concatenation of two arrays in sorted order without duplicate elements");
		int[] a = new int[] {4,2,5,1};
		int[] b = new int[] {8,1,9,5};
		int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
		System.out.println(Arrays.toString(c));
		
		//Sum of first 10 natural numbers
		System.out.println("Sum of first 10 natural numbers");
		int sumTen = IntStream.range(1, 11).sum();
		System.out.println(sumTen);
		
		//Find Strings which start with numbers
		List<String> listOfString = Arrays.asList("One","2wo","Three","4our","Five");
		System.out.println("Strings which start with numbers");
		listOfString.stream().filter(s->Character.isDigit(s.charAt(0))).forEach(System.out::println);
		
		//Frequency of each character in a String
		String str = "Ashutosh and Harsh are good friends";
		Map<Character,Long> countChar = str.chars().mapToObj(d->(char)d).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(countChar);
		
		//Sort the list of Strings in increasing order of their length
		System.out.println("Sort the list of strings in increasing order of their length");
		stringList.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		
		//Two Strings are anagrams or not
		String s1 = "Worth";
		String s2 = "Throw";
		String s3 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		String s4 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		if(s3.equals(s4))
			System.out.println("Given Strings are anagrams");
		else
			System.out.println("Given Strings are not anagrams");
		
		//Common element between two lists
		System.out.println("Common elements between two lists");
		List<Integer> secList = Arrays.asList(8,5,18,49,95,81,53,30,93);
		list.stream().filter(n->secList.contains(n)).forEach(System.out::println);
		
		//Sum of all digits of a number
		System.out.println("Sum of all digits of a number");
		int sumDigits = Stream.of(String.valueOf(54634).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sumDigits);
	}

}
