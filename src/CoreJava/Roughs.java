package CoreJava;

import java.util.Arrays;

public class Roughs {
	public static void main(String[] args) {
//		int single[] = { 2, 1,4, 6, 3, 7 };
//		int multi[] = { 10,0,5,8,9,7,4,1,4,6};
//		int l = single.length+1;
//		revInt(369);
//		factorial(6);
//		System.out.println("Recursive Factorial : " + factorialWithRecursiv(6));
//		revString("KHOSRUZ");
//		strPalindrom("madam");
//		intPalindrom(22322);
//		fibonacciNum(10);
//		someOfDigit(123654);
//		bigAndSmallNumber(36, 95, 77);
//		bigAndSmallNumberFromArray(single);
//		missingNumberFromArray(single);
//		System.out.println("Missing num : "+missingNumberFromArray2(single, l));
//		multi_missing_from_array(multi);
		primeOrNot(27);

	}

	public static void revInt(int n) {
		int temp = n;
		int sum = 0;
		int r = 0;
		while (temp != 0) {
			r = temp % 10;
			sum = sum * 10 + r;
			temp = temp / 10;
		}
		System.out.println("The Revers number is " + sum + ", against of " + n);
	}

	public static void factorial(int n) {
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial = factorial * i;
		}
		System.out.println("Factorial value for " + n + " is : " + factorial);

	}

	public static int factorialWithRecursiv(int n) {
		if (n == 0)
			return 1;
		return n * factorialWithRecursiv(n - 1);

	}

	public static void revString(String n) {
		StringBuffer sb = new StringBuffer(n);
		StringBuffer result = sb.reverse();
		System.out.println("Reverst String of '" + n + "' is '" + result + "'");
	}

	public static void strPalindrom(String s) {
		StringBuffer sb = new StringBuffer(s);
		StringBuffer result = sb.reverse();
		if (s.contentEquals(result)) {
			System.out.println(s + " is a Palindrom.");
		} else {
			System.out.println(s + " is not a Palindrom");
		}

	}

	public static void intPalindrom(int n) {
		int temp = n;
		int r = 0;
		int sum = 0;

		while (temp != 0) {
			r = temp % 10;
			sum = sum * 10 + r;
			temp = temp / 10;
		}
		if (sum == n) {
			System.out.println("Number of '" + n + "' Is a Palindrom.");
		} else {
			System.out.println("Number of '" + n + "' Is not a Palindrom..");
		}

	}

	public static void fibonacciNum(int n) {
		int fibonacci = 0;
		int num1 = 0;
		int num2 = 1;
		for (int i = 0; i <= n; i++) {
			fibonacci = num1 + num2;
			// System.out.println(fibonacci);
			num1 = num2;
			num2 = fibonacci;
		}
		System.out.println("The Fibonacci of '" + n + "' is : " + fibonacci);

	}

	public static void someOfDigit(int n) {
		int temp = n;
		int r = 0;
		int sum = 0;
		while (temp != 0) {
			r = temp % 10;
			sum = sum + r;
			temp = temp / 10;
		}
		System.out.println("The Sum of digits for '" + n + "' is : '" + sum + "'");

	}

	public static void bigAndSmallNumber(int a, int b, int c) {
		if (a > b && a > c) {
			System.out.println("Bigest Num is " + a);
		} else if (b >= a && b >= c) {
			System.out.println("Bigest Num is " + b);
		} else {
			System.out.println("bigest Num is " + c);
		}
	}

	public static void bigAndSmallNumberFromArray(int arr[]) {
		int len = arr.length;
		System.out.print("Sorted List is : ");
		for (int i = 0; i < len; i++) {
			Arrays.sort(arr);
			System.out.print(arr[i] + ", ");
		}

		System.out.println("\nLargest Number from the list is: " + arr[len - 1]);
		System.out.println("Middle Number from the list is: " + arr[(len / 2)]);
		System.out.println("Smallest Number from the list is: " + arr[0]);
	}

	public static void primeOrNot(int n) {
	/* Prime number is defined when:
	   1. Not Even except 2
	   2. Last Index is not 5
	   3. Not Divisible by 3 or 7
	 */
		
		boolean isPrime = true;
		for(int i=2; i<n; i++) {
			if(n % i == 0) {
				isPrime = false;
				break;
			}
		}
		
		if(isPrime) {
			System.out.println(n+ " Is a Prime Number.");
		}else {
			System.out.println(n+" Is not a Prime Number.");
		}
	}
	public static void armstrongOrNot() {

	}

	public static void missingNumberFromArray(int n[]) {

		int sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum = sum + n[i];
		}
		System.out.println("Sum of array is : " + sum);

		int sumOfRange = 0;
		for (int i = 1; i <= 7; i++) {
			sumOfRange = sumOfRange + i;
		}
		System.out.println("Sum of range : " + sumOfRange);

		System.out.println("Missing number is : " + (sumOfRange - sum));

	}

	public static int missingNumberFromArray2(int a[], int n) {
		int sum = n * (n+1)/2;
		for(int i=0; i<a.length; i++) {
			sum = sum - a[i];
		}
		return sum;

	}
	public static void multi_missing_from_array(int arr[]) {
		
		int arr2[] = new int[arr.length+1];
		
		for(int i:arr) {
			arr2[i]=1;
		}
		System.out.print("Multi Missing Numbers : ");
		for(int i = 1; i<arr2.length; i++) {
			if(arr2[i]==0) {
				System.out.print(i+", ");
			}
		}
		
	}
	
	
	public static void UpperAndLowerCase() {

	}

	public static void decimalToBionary() {

	}

	public static void leapYear() {

	}
	public static void readFiles() {

	}
	public static void with_Sort_Move_Zeros_To_Right() {
		
	}
	public static void without_Sort_move_Zero_To_End() {}

}

/*
 * public static void revString(String n) {
 * 
 * String temp = "" + n;
 * 
 * StringBuffer sb = new StringBuffer(temp); 
 * StringBuffer r = sb.reverse();
 * System.out.println(r.toString());
 * 
 * }
 */
