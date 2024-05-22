package javacoding;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Questions {

	public static void main(String[] args) {
		
		//To remove duplicates from the Array
		System.out.println("Remove duplicates from the array");
		int arr[] = new int[] {10,15,8,49,25,98,25,32,10};
		int out[] = Arrays.stream(arr).distinct().toArray();
		System.out.println(Arrays.toString(out));
		
		//To reverse a string without using the third variable
		System.out.println("Reverse a String");
		String str = "Hello World";
		String reverseString = new StringBuilder(str).reverse().toString();
		System.out.println(reverseString);
		
		System.out.println("Reverse the string using the Stream API");
		String outputReverse = str.chars()
					.mapToObj(c->String.valueOf((char)c))
					.collect(Collectors.collectingAndThen(Collectors.toList(),
															lst-> { 
																	Collections.reverse(lst);
																	return lst.stream();
															}))
					.collect(Collectors.joining());
		
		System.out.println(outputReverse);
		
		//Find 5th largest number present in an array
		System.out.println("Fifth largest number in the array");
		int fifthLargest = Arrays.stream(arr).distinct().mapToObj(n->(int)n).sorted(Collections.reverseOrder()).skip(4).findFirst().get();
		System.out.println(fifthLargest);
		
		//Suppose you have two strings, find out whether both strings are identical or not ? don't compare by word, compare character by character
		System.out.println("Using normal loop");
		String str1 = "Hello";
		String str2 = "HEllo";
		boolean marker = true;
		if(str1.length() != str2.length())
			System.out.println("Strings are not identical");
		else
		{
			for(int i=0;i<str1.length();i++)
			{
				if(str1.charAt(i) != str2.charAt(i)) {
					System.out.println("Strings are not identical");
					marker = false;
					break;
				}			
			}
			if (marker == true)
				System.out.println("Strings are identical");
		}
		
		System.out.println("Using Stream API");
		boolean result = IntStream.range(0, str1.length()).allMatch(i->str1.charAt(i) == str2.charAt(i));
		if(result == true)
			System.out.println("Strings are identical");
		else
			System.out.println("Strings are not identical");
		
		//Write a program to count the number of matching character in the pair of the string1 “abcd” and string2 “abad”. output is 3 .
		String str3 = "Abcdmmm";
		String str4 = "abadm";
		int size = str3.length();
		int count = 0;
		if(str3.length()>str4.length())
			size = str4.length();
		for(int i=0;i<size;i++) {
			if(str3.charAt(i) == str4.charAt(i))
				count++;
		}
		System.out.println(count + " number of matching characters");
		
		//Frequency of characters in String
		System.out.println("Frequency of characters");
		String str5 = "abbc";
		Map<Character, Long> frequency = str5.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(frequency);
		
		int arr2[] = {8, 6, 0, 4, 6, 4, 2, 7};
		Arrays.sort(arr2);
		int sum = arr2[arr2.length - 1];
		for(int i=arr2.length-2;i>=0;i--) {
			sum = (sum * 10) + arr2[i];
		}
		System.out.println("Largest number of given digits : " + sum );
		
		System.out.println("Using Stream Api");
		String[] digitString = Arrays.stream(arr2).mapToObj(String::valueOf).toArray(String[]::new);
		Arrays.sort(digitString, Comparator.reverseOrder());
		String largest = Arrays.stream(digitString).collect(Collectors.joining());
		System.out.println(largest);
		
		//sum of odd and even numbers in the list
		List<Integer> listNumbers = Arrays.asList(21,12,32,43,57,65,23);
		int sumEven = listNumbers.stream().filter(n->n%2==0).mapToInt(Integer::intValue).sum();
		System.out.println(sumEven);
		
		int sumOdd = listNumbers.stream().filter(n->n%2 != 0).mapToInt(Integer::intValue).sum();
		System.out.println(sumOdd);
		
		//Compare two arrays
		int arr3[] = {3,2,5,7,9};
		int arr4[] = {2,3,5,7};
		Arrays.sort(arr3);
		Arrays.sort(arr4);
		boolean compare = Arrays.equals(arr3, arr4);
		if(compare)
			System.out.println("Given Arrays are equal");
		else
			System.out.println("Arrays are not equal");
		
		//Remove all the occurences of a character from a given string
		String inputStr = "Why I am here?";
		char target = 'e';
		String outputString = inputStr.chars().filter(ch->ch!=target).mapToObj(ch->String.valueOf((char)ch)).collect(Collectors.joining());
		System.out.println(outputString);
		
		
		//find the words starting with vowels
		System.out.println("Words starting with vowels");
		String sentence = "The quick brown fox jumps over the lazy dog";
		String[] words = sentence.split("\s+");
		List<String> wordsStartingVowels = Arrays.stream(words).filter(word->word.matches("^(?i)[aeiou].*")).collect(Collectors.toList());
		System.out.println(wordsStartingVowels);
		
		//sort the array in descending order
		System.out.println("Sort the array in descending order");
		int arr5[] = {3,2,5,7,9,1,6};
		int[] sorted = Arrays.stream(arr5).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(sorted));
		
		
		Arrays.sort(arr5);
		int[] reversed = IntStream.range(0, arr5.length).map(i->arr[arr.length-i-1]).toArray();
		System.out.println(Arrays.toString(reversed));
		
		//Find the sum of the digits in the String
		System.out.println("Sum of the digits in the string");
		String s = "ab12pq34";
		int sumofDigits = s.chars().filter(Character::isDigit).map(Character::getNumericValue).sum();
		System.out.println(sumofDigits);
		
	}

}
