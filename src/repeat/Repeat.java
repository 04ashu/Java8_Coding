package repeat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Repeat {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,25,32,10);
		
		//Even Numbers from the list
		System.out.println("Even Numbers from the list");
		list.stream().filter(n->n%2==0).forEach(System.out::println);
		
		//Numbers starting with '1'
		System.out.println("Numbers starting with 1");
		list.stream().map(s->s+"").filter(s->s.startsWith("1")).forEach(System.out::println);
		
		//to remove the duplicates
		System.out.println("Removing Duplicates");
		list.stream().distinct().forEach(System.out::println);
		
		//to find the duplicates
		System.out.println("Duplicate numbers using Frequency");
		list.stream().filter(n->Collections.frequency(list, n)>1).collect(Collectors.toSet()).forEach(System.out::println);
		
		System.out.println("Duplicate numbers using Set");
		Set<Integer> set = new HashSet();
		list.stream().filter(n->!set.add(n)).forEach(System.out::println);
		
		//find the first element from  the list
		System.out.println("First element from the list");
		int firstElement = list.stream().findFirst().get();
		System.out.println(firstElement);
		
		//total number of elements in the list
		System.out.println("Total number of elements");
		long count = list.stream().count();
		System.out.println(count);
		
		//maximum number
		System.out.println("Maximum number from the list");
		int max = list.stream().max(Comparator.naturalOrder()).get();
		System.out.println(max);
		
		//minimum number
		System.out.println("Minimum number in the list");
		int min = list.stream().min(Integer::compare).get();
		System.out.println(min);
		
		//sorted 
		System.out.println("Sorting in Natural order");
		list.stream().sorted().forEach(System.out::println);
		
		//sorted in reverse order
		System.out.println("Sorting in reverse order");
		list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		
		//cube of elements and number greater than 1200
		System.out.println("Cube and greater than 1200");
		list.stream().map(n->n*n*n).filter(n->n>1200).forEach(System.out::println);
		
		//convert the list of strings to uppercase
		System.out.println("List of strings to uppercase");
		List<String> nameList = Arrays.asList("Foo", "Bar", "Bar", "Bar", "Foo");
		nameList.stream().map(String::toUpperCase).forEach(System.out::println);
		
		//count each element of the list
		System.out.println("Count of each element");
		Map<Integer,Long> countElement = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(countElement);
		
		//find the duplicate elements count 
		System.out.println("Duplicate Elements Count");
		Map<Integer,Long> duplicateCount = list.stream().filter(n->Collections.frequency(list, n)>1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(duplicateCount);
		
		//print multiples of 5 from the list
		System.out.println("Multiples of 5 from the list");
		list.stream().filter(n->n%5==0).forEach(System.out::println);
		
		//three max and min numbers from the list
		System.out.println("Three max numbers from the list");
		list.stream().sorted(Collections.reverseOrder()).limit(3).forEach(System.out::println);
		
		System.out.println("Three min numbers from the list");
		list.stream().sorted().distinct().limit(3).forEach(System.out::println);
		
		//sum and average of all numbers in the array
		System.out.println("Sum of all  numbers in the array");
		int arr[] = new int[] {10,15,8,49,25,98,25,32,10};
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum); 
		
		System.out.println("Average of all numbers in the array");
		double average = Arrays.stream(arr).average().getAsDouble();
		System.out.println(average);
		
		//sum and average of all numbers in the list
		System.out.println("Sum of all numbers in the list");
		int sumList = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sumList);
		
		System.out.println("Average of all numbers in the list");
		double averageList = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(averageList);
		
		//Last element of the list
		System.out.println("Last element of the list");
		int last=list.stream().skip(list.size()-1).findFirst().get();
		System.out.println(last);
		
		//second largest number of the list
		System.out.println("Second maximum number of the list");
		int SecMax = list.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
		System.out.println(SecMax);
		
		//Find strings which start with numbers
		System.out.println("Strings which start with number");
		List<String> listOfString = Arrays.asList("One","2wo","Three","4our","Five");
		listOfString.stream().filter(s->Character.isDigit(s.charAt(0))).forEach(System.out::println);
		
		//Frequency of each character in a string
		System.out.println("Frequency of Each Character in a String");
		String str = "Ashutosh and Harsh are good friends";
		Map<Character,Long> characterCount = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(characterCount);
		
		//Sort the list of Strings in increasing order of their length
		System.out.println("Sorting of Strings in increasing order of their length");
		List<String> stringList = Arrays.asList("HTML","Kotlin","C#","Java","Python","C++","Cobol","C");
		stringList.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		
		//Join the list of strings with Prefix, Suffix and Delimiter
		System.out.println("list of strings with Prefix, Suffix and Delimiter");
		String output = stringList.stream().collect(Collectors.joining(",", "{", "}"));
		System.out.println(output);
		
		//Concatenation of two arrays 
		System.out.println("Concatenation of two arrays");
		int[] a = new int[] {4,2,5,1};
		int[] b = new int[] {8,1,9,5};
		int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
		System.out.println(Arrays.toString(c));
		
		//Two Strings are anagrams or not
		String s1 = "Worth";
		String s2 = "Throw";
		String s3 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		String s4 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		if(s3.equals(s4))
			System.out.println(s1 + " and " + s2 + " are anagrams");
		else
			System.out.println(s1 + " and " + s2 + " are not anagrams");
		
		//Common elements between two lists
		System.out.println("Common elements between two lists");
		List<Integer> secList = Arrays.asList(8,5,18,49,95,81,53,30,93);
		list.stream().filter(secList::contains).forEach(System.out::println);
		
		//Sum of first 10 natural numbers
		System.out.println("Sum of first 10 natural numbers");
		int sumNatural = IntStream.range(1, 11).sum();
		System.out.println(sumNatural);
		
		//Sum of all digits of a number 
		System.out.println("Sum of all digits of a number");
		int sumDigits = Stream.of(String.valueOf(15234).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sumDigits);
		
		//first 10 even numbers
		System.out.println("First 10 even numbers");
		IntStream.range(1, 21).filter(n->n%2==0).forEach(System.out::println);
		
	}

}
