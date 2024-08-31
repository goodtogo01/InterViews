package CoreJava;

import java.awt.Insets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class pp {
	public static void main(String[] args) {
		//sortedOrg();
		//sortedOrg();
		//sortIntArrayUserInput();
		TT();
		//MM();
	}
	
	public static void sortedOrg() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number between 1 - 100.");
		int[] array = new int[sc.nextInt()];
		int temp = array.length;
		int sum = 0;
		int r =0;
		
		while(temp !=0) {
			r = temp % 10;
			sum = sum*10+r;
			temp = temp/10;
		}
		System.out.println(sum);
	}
	public static void missingArrays() {
		
		
		int a[] = {2,4,6,0,3,5};
		int na[] = new int[a.length+1];
		
		for(int i: a) {
			na[i]=1;
		}
		System.out.print("Multiple number : ");
		for(int i=1; i<na.length; i++) {
			if(na[i]==0) {
				System.out.print(i);
			}
		}
		
		
		
		int a2[]= {2,3,4,5,6};
		int n = a2.length+1;
		int sum = n *(n+1)/2;
		for(int i=0; i<a2.length; i++) {
			sum = sum-a2[i];
		}
		System.out.println("\nSing number : "+sum);
	}
	public static void sortIntArrayUserInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your number: ");
		int number = sc.nextInt();
		int[] arr = new int[number];
		
		for(int i =0; i<number; i++) {
			arr[i]=sc.nextInt();
		}
		for(int i=number-1; i>0; i--) {
			System.out.println(arr[i]);
		}
	}
	public static void TT() {
		int a [] = {1,2,3,4,5,6,8};
		int len = a.length+1;
		int sum = len * (len+1)/2;
		
		for(int i = 0; i<a.length; i++) {
			sum = sum - a[i];
		}
		System.out.println(sum);
	}
	public static void MM() {
		
		int a [] = {1,2,3,4,5,0,0,8};
		int b[] = new int[a.length+1];
				
				for(int i:a) {
					b[i]=1;
				}
		for(int i= 0; i<b.length; i++) {
			if(b[i]==0) {
				System.out.println(i);
			}
		}
		
		
		
		
		
	}
}
