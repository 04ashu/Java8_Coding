package javacoding;

public class A {

	public static void main(String[] args) {
		
		C b  = new C();
		b.m1();

	}

}

class B {
	
	  public void m1() {
		  System.out.println("From B Class"); 
		  }
		 
	
}

class C extends B { 
	public void m1() {
		System.out.println("From C class"); 
		super.m1();
	}
}
