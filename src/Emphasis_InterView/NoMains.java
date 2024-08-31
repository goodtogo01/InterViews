package Emphasis_InterView;

import java.util.Arrays;

public class NoMains {

	public static void main(String[] args) {
		int m[]= {1,2,3,4,6,7,8,9};
		int n = m.length+1;
	 
		 
//		question_01();
//		without_Sort_Move_Zeros_To_Left();
//		System.out.println();
//		without_Sort_Move_Zeros_To_Right();
		//without_Sort_move_Zero_To_End();
		with_Sort_Move_Zeros_To_Right();
		System.out.println("\nThe missing number is : "+missingNumber(n, m));
		
	 
	}

	public static void question_01() {
		// write a program, where given string is "abc de" and expected output is "edc
		// ba"
		/*
		 * Step 1. Remove white space step 2. Reverse new string step 3. Add white space
		 * to particuler index
		 */
		String mainString = "abc de";
		int index = 3;

		// Step 1. Remove white space
		String newString = mainString.replace(" ", "");
		System.out.println("After Removed of space : " + newString.toString());

		// Step 2. Reverse new string
		StringBuffer sb = new StringBuffer(newString);
		sb.reverse();
		String reverseString = sb.toString();
		System.out.println("Reversed String is : " + reverseString);

		// Step 3. Add white space to particular index
		StringBuffer finalString = sb.insert(index, " ");
		System.out.println("Final Result is : " + finalString.toString());

	}

	public static void without_Sort_Move_Zeros_To_Left() {
		/*
		 * write a program, Given int arr[]={4,0,1,0,7,0,2,0}, Move all the 0's to left
		 * hand side in the array?"
		 */

		int[] arr = { 4, 0, 1, 0, 7, 0, 2, 0 };
		// Initialize two pointers
		int left = 0;
		int right = arr.length - 1;
		// Move the zeros to the left-hand side
		while (left < right) {
			// Increment left pointer until a non-zero element is found
			while (arr[left] == 0 && left < right) {
				left++;
			}
			// Decrement right pointer until a zero element is found
			while (arr[right] != 0 && left < right) {
				right--;
			}
			// Swap the non-zero element at left with the zero element at right
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		// Print the modified array
		System.out.print("Final Output: ");
		for (int num : arr) {
			System.out.print(num + " ");
		}

	}

	public static void without_Sort_Move_Zeros_To_Right() {
		/*
		 * write a program, Given int arr[]={4,0,1,0,7,0,2,0}, Move all the 0's to right
		 * hand side in the array?"
		 */
		int[] arr = { 4, 0, 1, 0, 7, 0, 2, 0 };
		// Initialize two pointers
		int left = 0;
		int right = arr.length - 1;
		// Move the zeros to the right-hand side
		while (left < right) {
			// Decrement right pointer until a non-zero element is found
			while (arr[right] == 0 && left < right) {
				right--;
			}
			// Increment left pointer until a zero element is found
			while (arr[left] != 0 && left < right) {
				left++;
			}
			// Swap the non-zero element at right with the zero element at left
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		// Print the modified array
		System.out.print("Final Output: ");
		for (int num : arr) {
			System.out.print(num + " ");
		}

	}

	public static void without_Sort_move_Zero_To_End() {
		int arr[]= {0,3,5,0,5,0,2,0,1,0};
		int len = arr.length;
		int count = 0;
		
		for(int i=0; i<len; i++) {
			if(arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		while(count < len) {
			arr[count++]=0;
		}
		for (int j=0; j<len; j++) {
			System.out.print(arr[j]+", ");
		}
	}

	public static void with_Sort_Move_Zeros_To_Right() {
		//Declear and initialize the array elements
		int array[] = {128, 0, 99, 67, 50, 0, 29, 7, 0};
		
		//getting the length of array
		int n = array.length;
		
		// Sorting arrays
		Arrays.sort(array);
		System.out.println("Final array, all zeros moved to right...");
		
		//Print arrays using loop
		for(int i=n-1; i>=0; i--) {
			System.out.print(array[i]+" ");
		}
		
	}
	public static int missingNumber(int n, int[]arr) {
		int sum = n * (n+1)/2;
		for(int i =0; i<arr.length; i++) {
			sum = sum-arr[i];
		}
		return sum;
		
	}
}
