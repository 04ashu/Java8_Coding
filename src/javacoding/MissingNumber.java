package javacoding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {

	public static void main(String[] args) {
		
		int[] arr = {1,2,4,5,6,7,8,9,10,11};
		int missingNumber = missing(arr);
		System.out.println("Missing number in the array is : " + missingNumber);

	}
	
	private static int missing(int[] arr) {
		
		int size = arr.length + 1;
		int expectedSum = IntStream.range(1, size+1).sum();
		int actualSum = Arrays.stream(arr).sum();
		
		return expectedSum-actualSum;
	}

}
