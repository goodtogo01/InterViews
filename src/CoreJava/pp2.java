package CoreJava;

import java.awt.Insets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class pp2 {
	public static void main(String[] args) {
		rvS("MADAM");
		reI(123);
		absOne();
		absMul();
	}

	public static void rvS(String s) {
		String temp = "" + s;
		
		StringBuffer sb = new StringBuffer(temp);
		StringBuffer rev = sb.reverse();
		System.out.println(rev.toString());
		if(s.equals(rev.toString())) {
			System.out.println("And this is a Palindrom");
		}else {
			System.out.println("This is not a Palindrom...");
		}

	}
	public static void reI(int i) {
		int temp = i;
		int sum = 0;
		int r = 0;
		
		while(temp !=0) {
			r = temp % 10;
			sum = sum * 10 +r;
			temp = temp / 10;
		}
		System.out.println(sum);
	}
	public static void absOne() {
		int arr[]= {1,2,3,4,6};
		int n = arr.length;
		int sum = n *(n+1)/2;
		
		for(int i=0; i<arr.length-1; i++) {
			sum = sum-arr[i];
		}
		System.out.println("Actual absent element is : "+sum);
	}
	public static void absMul() {
		
		int arr[]= {0,0,0,3,4,0,7};
		
		int n[]= new int[arr.length+1];
		
		for(int i:arr) {
			n[i]=1;
		}
		
		System.out.println("Missing numbers are : ");
		for(int i=1; i<n.length; i++) {
			if(n[i]==0) {
				System.out.print(i+", ");
			}
		}
	}

}
