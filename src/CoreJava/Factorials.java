package CoreJava;

public class Factorials {
	public static void main(String[] args) {
		factorials_01(6);
		System.out.println("\n******************* Factorial with Recurssion **************** ");
		System.out.println(recursive_Factorials(5));
	}
	
	public static void factorials_01(int n ) {
		System.out.println("******************* Factorial without Recurssion **************** ");
		int factorial = 1;
		for(int i = 1; i<=n; i++) {
			factorial = factorial * i;
		}
		System.out.println("Factorials for "+n+" is : "+factorial);
		
		
	}

	// Factorial with recurssion
	public static int recursive_Factorials(int n) {
	
		if (n == 1)
			return 1;
		return n * recursive_Factorials(n-1);
	}
	
	
}
