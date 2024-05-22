package repeat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Repeat8 {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,25,32,10);
		
		System.out.println("Even numbers from the list");
		list.stream().filter(n->n%2==0).forEach(System.out::println);
		
		System.out.println("Numbers staring with '1'");
		list.stream().map(s->s+"").filter(s->s.startsWith("1")).forEach(System.out::println);
		
		System.out.println("To remove the duplicates");
		list.stream().distinct().forEach(System.out::println);
		
		System.out.println("Find the duplicates");
		list.stream().filter(n->Collections.frequency(list, n)>1).collect(Collectors.toSet()).forEach(System.out::println);

		System.out.println("Duplicates with the help of a set");
		Set<Integer> set = new HashSet<>();
		list.stream().filter(n->!set.add(n)).forEach(System.out::println);
		
		System.out.println("Find the first element of the list");
		int first = list.stream().findFirst().get();
		System.out.println(first);
		
		System.out.println("Total number of elements in the list");
		long count = list.stream().count();
		System.out.println(count);
		
		System.out.println("Maximum number in the list");
		int max = list.stream().max(Integer::compare).get();
		System.out.println(max);
		
		System.out.println("Minimum number in the list");
		System.out.println(list.stream().min(Integer::compare).get());
		
		System.out.println("Sorting in ascending order");
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println("Sorting in descending order");
		list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		
		System.out.println("Cube of elements and number greater than 1200");
		list.stream().map(n->n*n*n).filter(n->n>1200).forEach(System.out::println);
		
		System.out.println("List of strings to uppercase");
		List<String> strList = Arrays.asList("lower","chotu","totu","rotu");
		strList.stream().map(String::toUpperCase).forEach(System.out::println);
		
		System.out.println("Count each element of the list");
		Map<Integer, Long> countElement = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(countElement);
		
		System.out.println("Duplicate elements count");
		Map<Integer, Long> dupCount = list.stream().filter(n->Collections.frequency(list, n)>1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(dupCount);
		
		System.out.println("Three max numbers in the list");
		list.stream().distinct().sorted(Collections.reverseOrder()).limit(3).forEach(System.out::println);
		
		System.out.println("Sum of all numbers in the array");
		int[] arr = {10,15,8,49,25,98,25,32,10};
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum);
		
		System.out.println("Average of all numbers in the array");
		System.out.println(Arrays.stream(arr).average().getAsDouble());
		
		System.out.println("Sum of all numbers in the list");
		System.out.println(list.stream().mapToInt(Integer::intValue).sum());
		
		System.out.println("Average of all numbers in the list");
		System.out.println(list.stream().mapToInt(Integer::intValue).average().getAsDouble());
		
		System.out.println("Last element of the list");
		System.out.println(list.stream().skip(list.size()-1).findFirst().get());
		
		System.out.println("Second largest number of the list");
		System.out.println(list.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get());
		
		System.out.println("First 10 even numbers");
		IntStream.range(1, 21).filter(n->n%2==0).forEach(System.out::println);
		
		System.out.println("Join the list of strings with prefix, suffix and delimiter");
		List<String> stringList = Arrays.asList("HTML","Kotlin","C#","Java","Python","C++","Cobol","C");
		String collect = stringList.stream().collect(Collectors.joining(",","{", "}"));
		System.out.println(collect);
		
		System.out.println("Concatenation of two arrays");
		int[] a = new int[] {4,2,5,1};
		int[] b = new int[] {8,1,9,5};
		int[] array = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
		System.out.println(Arrays.toString(array));
		
		System.out.println("Sum of first 10 natural numbers");
		System.out.println(IntStream.range(1,11).sum());
		
		System.out.println("Find strings which start with numbers");
		List<String> listOfString = Arrays.asList("One","2wo","Three","4our","Five");
		listOfString.stream().filter(s->Character.isDigit(s.charAt(0))).forEach(System.out::println);
		
		System.out.println("Frequency of each character in a string");
		String str = "Ashutosh and Harsh are good friends";
		Map<String, Long> countCharacter = Stream.of(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(countCharacter);
		
		System.out.println("Sort the list of strings in increasing order of their length");
		stringList.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		
		System.out.println("To check given strings are anagrams or not");
		String s1 = "Worth";
		String s2 = "Throw";
		String s3 = Stream.of(s1.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
		String s4 = Stream.of(s2.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
		if(s3.equals(s4))
			System.out.println("Given Words are Anagram");
		else
			System.out.println("Given words are not anagram");
		
		System.out.println("Common element between two lists");
		List<Integer> secList = Arrays.asList(8,5,18,49,95,81,53,30,93);
		list.stream().filter(secList::contains).forEach(System.out::println);
		
		System.out.println("Sum of all digits of a number");
		Integer sumDigits = Stream.of(String.valueOf("196456").split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sumDigits);
		
		System.out.println("Find if given string is present in the list of strings");
		List<String> string1 = Arrays.asList("Angular","C#","Java");
		boolean anyMatch = string1.stream().anyMatch(str1->str1.equals("Java"));
		System.out.println(anyMatch);
		
	}

}
