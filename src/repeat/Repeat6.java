package repeat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repeat6 {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,25,32,10);
		
		list.stream().filter(n->Collections.frequency(list, n)>1).collect(Collectors.toSet()).forEach(System.out::println);
		
		String str = "abababghgjgfhioem";
		
		Map<String, Long> collect = Stream.of(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

		collect.entrySet().stream().filter(entry->entry.getValue()>2).map(Map.Entry::getKey);
		
		List<String> listOfString = Arrays.asList("One","2wo","Three","4our","Five");
		
		listOfString.stream().filter(s->Character.isDigit(s.charAt(0))).forEach(System.out::println);
		
		System.out.println("Frequency of each character in a string");
		String str1 = "Ashutosh and Harsh are good friends";
	
		Map<Character, Long> collect2 = str1.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(collect2);
		
		listOfString.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		
		String str2 = "Hello World";
		String outputString="";
		for(int i=str2.length()-1;i>=0;i--)
			outputString+=str2.charAt(i);
		System.out.println(outputString);
		
		String[] split = str2.split(" ");
		Optional<String> reduce = Arrays.stream(split).reduce((word1,word2)-> word2 + " " + word1);
		System.out.println(reduce.get());
		System.out.println(str2.length());
		System.out.println(reduce.get().length());
		
		String str3 = "abababghgjgfhioem";
		Map<Character, Long> collect3 = str3.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		List<Character> collect4 = collect3.entrySet().stream().filter(entry->entry.getValue()>2).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(collect4);
		
	}
	

}
