package javacoding;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Questions2 {

	public static void main(String[] args) {
		
		//To remove duplicates from the Array
		System.out.println("Remove duplicates from the array");
		int arr[] = new int[] {10,15,8,49,25,98,25,32,10};
		int[] output = Arrays.stream(arr).distinct().toArray();
		System.out.println(Arrays.toString(output));
		Set<Integer> set = new HashSet();
		int[] dupElements = Arrays.stream(arr).filter(n->!set.add(n)).toArray();
		System.out.println(Arrays.toString(dupElements));
		
		//Write a program to reverse a string without using the third variable
		System.out.println("Reverse a String");
		String str = "Hello World";
		System.out.println(new StringBuilder(str).reverse().toString());
		
		String reverseString = str.chars().mapToObj(c->String.valueOf((char)c))
					.collect(Collectors.collectingAndThen(Collectors.toList(),
															lst-> {
																	Collections.reverse(lst);
																	return lst.stream();
															}))
					.collect(Collectors.joining());
		
		System.out.println(reverseString);
		
		//Find 5th largest number present in an array
		int fifthLargest = Arrays.stream(arr).distinct().mapToObj(n->(int)n).sorted(Collections.reverseOrder()).skip(4).findFirst().get();
		System.out.println(fifthLargest);
		
		String str1 = "Hello";
		String str2 = "HEllo";
		if(str1.equals(str2))
			System.out.println("Strings are identical");
		else
			System.out.println("String are not identical");
		
		int arr2[] = {8, 6, 0, 4, 6, 4, 2, 7};
		Arrays.sort(arr2);
		int sum = arr2[arr2.length-1];
		for(int i=arr2.length-2;i>=0;i--) {
			sum=sum*10 + arr2[i];
		}
		System.out.println(sum);
		
		List<Integer> list = Arrays.asList(11, 18, 20, 24, 85, 66,13);
		List<Integer> collect = list.stream().map(s->s+"").filter(n->n.startsWith("1")).map(Integer::parseInt).collect(Collectors.toList());
	}

}

