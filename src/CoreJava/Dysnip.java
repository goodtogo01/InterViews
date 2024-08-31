package CoreJava;

import java.util.Arrays;

public class Dysnip {
	public static void main(String[] args) {

		int m[] = {1,2,3,5,4,7};
		//bigAndSmallNum(m);
		missingNumber(m);
	}


	public static void bigAndSmallNum(int a[]) {
/*first to find the length, 
		then iterate, 
		then use method of Arrays.sort(array[a]), 
		then display with index for Big, MId, or Small*/
		
		
		int len = a.length; //length
		System.out.print("Sorted Array : ");
		for(int i = 0; i<len; i++) { // Iterate
			Arrays.sort(a); // Sort
			System.out.print(a[i]+", "); // Display sorted array
		}
		System.out.println("\nSmall Number is : "+a[0]);
		System.out.println("Middle Number is : " + a[len/2]);
		
		System.out.println("Big Number is : "+a[len-1]);
		
	}
	public static void missingNumber(int a[]) {
		/* Find the length and add 1
		 * use algorithm of n*(n+1)/2 as sum
		 * iterate through loop with actual length of array
		 * within loop, deduct arrays[i] from sum
		 * print sum for missing number
		 * 
		 * */
		
		int n = a.length+1;
		int sum = n * (n+1)/2;
		for(int i=0; i<a.length; i++) {
			sum = sum -a[i];
		}
		System.out.println("Missing number is : "+sum);
	}
	
}
