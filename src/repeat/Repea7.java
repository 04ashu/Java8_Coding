package repeat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Repea7 {

	public static void main(String[] args) {
		
		List<String> a1 = Arrays.asList("gynmastic","cricket","swimming");
		List<String> a2 = Arrays.asList("footbaal","hockey","swimming");
		List<String> a3 = Arrays.asList("pool","cricket","javelin");
		List<List<String>> listofStrings = Arrays.asList(a1,a2,a3); 
		List<Object> collect = listofStrings.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(collect);
		
		
	}

}
