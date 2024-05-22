package concept;

import java.util.ArrayList;
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

public class JavaConcept {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10,15,8,49,25,98,25,32,10);
		List<Integer> secList = Arrays.asList(8,5,18,49,95,81,53,30,93);
		List<String> listOfString = Arrays.asList("One","2wo","Three","4our","Five");
		Set<Integer> set = new HashSet();
		int arr[] = new int[] {10,15,8,49,25,98,25,32,10};
		
		//remove duplicate elements from the list
		list.stream().distinct().forEach(System.out::println);
		
		//sort the list in reversed order
		System.out.println("Sorting Reverse Order");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		//Print Multiples of 5 from the list
		System.out.println("Print Multiples of 5");
		list.stream().filter(n->n%5 == 0).forEach(System.out::println);
		
		//three max and min numbers from the list
		System.out.println("Three max numbers");
		list.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		System.out.println("Three min numbers");
		list.stream().distinct().sorted().limit(3).forEach(System.out::println);
		
		//sum and average of all numbers in the array
		System.out.println("Sum of al numbers from the array");
		System.out.println(Arrays.stream(arr).sum());
		System.out.println("Average of al numbers from the array");
		System.out.println(Arrays.stream(arr).average().getAsDouble());
		
		//sum and average of all numbers in the list
		System.out.println("Sum of al numbers in the list");
		int sum = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		System.out.println("Average of al numbers in the list");
		double average = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(average);
		
		//last element of the list
		System.out.println("Last element of the list");
		int last = list.stream().skip(list.size() - 1).findFirst().get();
		System.out.println(last);
		
		//max of the list
		System.out.println("Maximum");
		int max = list.stream().max(Comparator.naturalOrder()).get();
		System.out.println(max);
		
		//min of the list
		System.out.println("Minimum");
		int min = list.stream().min(Comparator.naturalOrder()).get();
		System.out.println(min);
		
		//Second largest number in the list
		System.out.println("Second largest from the list");
		int secMax=list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(secMax);
		
		//duplicate elements from the list
		System.out.println("Duplicate elements");
		list.stream().filter(n->Collections.frequency(list, n)>1).collect(Collectors.toSet()).forEach(System.out::println);
		System.out.println("Duplicate elements using set");
		list.stream().filter(n->!set.add(n)).forEach(System.out::println);
		
		//find strings which start with numbers
		System.out.println("Strings started with number");
		listOfString.stream().filter(s->Character.isDigit(s.charAt(0))).forEach(System.out::println);
		
		//Frequency of each element
		System.out.println("Frequency of each element");
		Map<Integer, Long> groupCount= list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(groupCount);
		
		//Frequency of each character in a String
		String str = "Ashutosh and Harsh are good friends";
		Map<Character,Long> charCount = str.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(charCount);
		
		//Sort the list of Strings in increasing order of their length
		System.out.println("Sorting of Strings in increasing order of their length");
		List<String> stringList = Arrays.asList("HTML","Kotlin","C#","Java","Python","C++","Cobol","C");
		stringList.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		
		//Join the list of strings with Prefix, Suffix and Delimiter
		System.out.println("list of strings with Prefix, Suffix and Delimiter");
		String output = stringList.stream().collect(Collectors.joining(" and ", "{","}" ));
		System.out.println(output);
		
		//Merge two unsorted arrays into a single sorted array
		int[] a = new int[] {4,2,5,1};
		int[] b = new int[] {8,1,9,5};
		int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();
		System.out.println(Arrays.toString(c));	
		
		//Two Strings are anagrams or not
		String s1 = "Worth";
		String s2 = "Throw";
		String s3 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		String s4 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		if(s3.equals(s4))
			System.out.println("Given strings are Anagrams");
		else
			System.out.println("Given strings are not Anagrams"); 
		
		//Common elements between two lists
		System.out.println("Common elements between two lists");
		list.stream().filter(secList::contains).forEach(System.out::println);
		
		//Sum of first 10 natural numbers
		System.out.println("Sum of first 10 natural numbers");
		int sumN = IntStream.range(1, 11).sum();
		System.out.println(sumN);
		
		//Sum of all digits of a number 
		System.out.println("Sum of all digits of a number");
		int sumOfDigits = Stream.of(String.valueOf(51365).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sumOfDigits);
		
		//first 10 even numbers
		System.out.println("First 10 even numbers");
		IntStream.range(1, 21).filter(n->n%2==0).forEach(System.out::println);
		
		//Number Starts with "1"
		System.out.println("Number starts with 1");
		list.stream().map(n->n+"").filter(s->s.startsWith("1")).forEach(System.out::println);
		

	}

}
