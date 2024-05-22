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

public class Repeat3 {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,25,32,10);
		
		//even numbers from the list
		System.out.println("Even numbers from the list");
		list.stream().filter(n->n%2==0).forEach(System.out::println);
		
		//Numbers starting with '1'
		System.out.println("Numbers starting with '1'");
		list.stream().map(s->s+"").filter(s->s.startsWith("1")).forEach(System.out::println);
		
		//to remove duplicates
		System.out.println("Remove duplicates from the list");
		list.stream().distinct().forEach(System.out::println);
		
		//To find the duplicates
		System.out.println("To find the duplicates");
		list.stream().filter(n->Collections.frequency(list, n)>1).collect(Collectors.toSet()).forEach(System.out::println);
		
		System.out.println("Duplicates With the help of set");
		Set<Integer> set = new HashSet();
		list.stream().filter(n->!set.add(n)).forEach(System.out::println);
		
		//find the first element from the list
		System.out.println("Find the first element from the list");
		int first = list.stream().findFirst().get();
		System.out.println(first);
		
		//total number of elements in the list
		System.out.println("Total number of elements in the list");
		Long count = list.stream().count();
		System.out.println(count);
		
		//maximum number
		System.out.println("Maximum Number in the list");
		int max = list.stream().max(Comparator.naturalOrder()).get();
		System.out.println(max);
		
		//minimum number
		System.out.println("Minimum number in the list");
		int min = list.stream().min(Integer::compare).get();
		System.out.println(min);
		
		//sorting 
		System.out.println("Sorting in natural order");
		list.stream().sorted().forEach(System.out::println);
		
		System.out.println("Sorting in reverse order");
		list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		
		//Cube of element and number greater than 1200
		System.out.println("Cube of elements and number greater than 1200");
		list.stream().map(n->n*n*n).filter(n->n>1200).forEach(System.out::println);
		
		//convert the list of strings of to uppercase
		List<String> strList = Arrays.asList("foo","boo","woo","tru") ;
		System.out.println("Convert the list of strings to uppercase");
		strList.stream().map(String::toUpperCase).forEach(System.out::println);
		
		//Count each elements of the list
		System.out.println("Count each element of the list");
		Map<Integer,Long> countMap = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(countMap);
		
		//find the duplicate elements count
		System.out.println("Find the duplcate elements count");
		Map<Integer,Long> duplicateCount = list.stream().filter(n->Collections.frequency(list, n)>1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(duplicateCount);
		
		//print multiples of 5 from the list
		System.out.println("Multiples of 5 from the list");
		list.stream().filter(n->n%5 == 0).forEach(System.out::println);
		
		//Three min and max numbers from the list
		System.out.println("Three max numbers from the list");
		list.stream().sorted(Collections.reverseOrder()).limit(3).forEach(System.out::println);
		
		System.out.println("Three min numbers from the list");
		list.stream().distinct().sorted().limit(3).forEach(System.out::println);
		
		//Sum and average of all numbers in the array
		int arr[] = new int[] {10,15,8,49,25,98,25,32,10};
		System.out.println("Sum of all numbers in the array");
		int sumArray = Arrays.stream(arr).sum();
		System.out.println(sumArray);
		
		System.out.println("Average of all numbers in the list");
		double averageArray = Arrays.stream(arr).average().getAsDouble();
		System.out.println(averageArray);
		
		//sum and average of all numbers in the list
		System.out.println("Sum of all numbers in the list");
		int sumList = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sumList);
		
		System.out.println("Average of all numbers in the list ");
		double averageList = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(averageList);
		
		//Last element of the list
		System.out.println("Last element of the list");
		int last = list.stream().skip(list.size()-1).findFirst().get();
		System.out.println(last);
		
		//second largest number of the list
		System.out.println("Second Largest element of the list");
		int secondLargest = list.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
		System.out.println(secondLargest);
		
		//First 10 even numbers
		System.out.println("First 10 even numbers");
		IntStream.range(1, 21).filter(n->n%2==0).forEach(System.out::println);
		
		//Find strings which start with numbers
		List<String> listOfString = Arrays.asList("One","2wo","Three","4our","Five");
		System.out.println("Find Strings which start with numbers");
		listOfString.stream().filter(s->Character.isDigit(s.charAt(0))).forEach(System.out::println);
		
		//Frequency of each character in a string
		String str = "Ashutosh and Harsh are good friends";
		System.out.println("Frequency of each charachter in a string");
		Map<Character,Long> charCount = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(charCount);
		
		//Sort the list of strings in increasing order of their length
		List<String> stringList = Arrays.asList("HTML","Kotlin","C#","Java","Python","C++","Cobol","C");
		System.out.println("Sort the list of strings in increasing order of their length");
		stringList.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		
		//Join the list of strings with Prefix,suffix and delimiter
		System.out.println("Join the list of strings with Prefix,suffix and delimiter");
		String outputString = stringList.stream().collect(Collectors.joining("," , "{" ,"}" ));
		System.out.println(outputString);
		
		//Concatenation of two arrays in sorted order without duplicate elements
		System.out.println("Concatenation of two arrays in sorted order without duplicate elements");
		int[] a = new int[] {4,2,5,1};
		int[] b = new int[] {8,1,9,5};
		int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
		System.out.println(Arrays.toString(c));
		
		//Two Strings are anagrams are not
		String s1 = "Worth";
		String s2 = "Throw";
		String s3 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		String s4 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		
		if(s3.equals(s4))
			System.out.println("Given Strings are anagrams");
		else
			System.out.println("Given Strings are not anagrams");
		
		//Common elements between two lists
		System.out.println("Common elements between two lists");
		List<Integer> secList = Arrays.asList(8,5,18,49,95,81,53,30,93);
		list.stream().filter(secList::contains).forEach(System.out::println);
		
		//Sum of first 10 natural numbers
		System.out.println("Sum of first 10 natural numbers");
		int sumTen = IntStream.range(1, 11).sum();
		System.out.println(sumTen);
		
		//sum of all digits of a number
		System.out.println("Sum of all digits of a number");
		int sumDigits = Stream.of(String.valueOf(15473).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sumDigits);
		
			
	}

}
