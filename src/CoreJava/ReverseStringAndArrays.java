package CoreJava;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class ReverseStringAndArrays {
	public static void main(String[] args) {
		stringReverse_01();
		stringReverse_02();
		palindromWithString("KHOK");
	}

	public static void stringReverse_01() {
		System.out.println("********** REVERSE STRING FOR ARRAYS ****************************");
		String[] s = {"F", "G", "H", "M", "N", "A", "S", "Y", "L"};
		
		// Original List
		System.out.println("Original String List : "+Arrays.toString(s));
		
		// Using Arrays.sort to sorting actual String
		Arrays.sort(s);
		System.out.println("Sorted List: "+ Arrays.toString(s));
		
		// Descending Order
		Arrays.sort(s, Collections.reverseOrder());
		System.out.println("Sorted List with reverse orders : "+ Arrays.toString(s));
	}
	public static void stringReverse_02() {
		System.out.println("\n********** REVERSE STRING WITH STRING BUFFER ****************************");
		String s = "ZLMJFDC";
		// Original String
		System.out.println("Original String : "+s.toString());
		//StringBuffer sb = new StringBuffer(s);
		StringBuilder sb  = new StringBuilder(s);
		sb.reverse();
		System.out.println("After Reversde : "+sb.toString());
	}
	public static void palindromWithString(String s) {
		System.out.println("\n********** REVERSE STRING WITH STRING BUFFER ****************************");
		// Original String
		System.out.println("Original String : "+s.toString());
		//StringBuffer sb = new StringBuffer(s);
		StringBuilder sb  = new StringBuilder(s);
		StringBuilder rev = sb.reverse();
		System.out.println("After Reversde : "+sb.toString());
		if (s.contentEquals(rev)) {
			System.out.println("This is a Palindrom.");
		}else {
			System.out.println("This is not a Palindrom");
		}
	}
}
