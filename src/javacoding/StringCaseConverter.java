package javacoding;

public class StringCaseConverter {

	public static void main(String[] args) {
		
		String str = "HelloWorld";
		String convertedString = converter(str);
		System.out.println(convertedString);
		
	}
	
	private static String converter(String str) {
		
		int halfLength = str.length()/2;
		
		String firstHalf = str.substring(0, halfLength);
		String secondHalf = str.substring(halfLength);
		
		return firstHalf.toLowerCase() + secondHalf.toUpperCase();
	}

}
