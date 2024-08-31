package CoreJava;

import java.util.Arrays;
import java.util.Iterator;

public class Fabonacci_Series {
	public static void main(String[] args) {

		int ar[] = { 6, 5, 2, 4, 9, 8, 5, 1, -1, 0 };
		
		int len = ar.length;
		System.out.print("\nSorted : ");
		for(int i = 0; i<len; i++) {
			Arrays.sort(ar);
			System.out.print(ar[i]+" ");
		}

		

		System.out.print("\nLargest Number:  "+(len-1));

		System.out.print("\nSmallest number is : "+(ar[0]));
		als(ar);
	}
	
	
	public static void als(int a[]) {
		int len = a.length;
		for (int i = 0; i<len; i++) {
			Arrays.sort(a);
		}
		System.out.println("\nLarg : "+(len-1));
		System.out.println("Small : "+(a[0]));
	}
}
