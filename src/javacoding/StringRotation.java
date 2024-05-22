package javacoding;

public class StringRotation {

	public static void main(String[] args) {
	String str1 = "abcd";
	String str2 = "cdab";
	
	boolean result = areRotation(str1, str2);
	
	if(result)
		System.out.println("Strings are rotational");
	else
		System.out.println("Strings are not rotational");
	}
	
	private static boolean areRotation(String str1, String str2) {
		
		if(str1.length()!=str2.length() || str1.isEmpty() || str2.isEmpty())
			return false;
		
		String concatenated = str1+str1;
		if(concatenated.contains(str2))
			return true;
		else
			return false;		
			
	}

}
