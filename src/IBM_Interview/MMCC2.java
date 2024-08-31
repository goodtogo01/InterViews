package IBM_Interview;

import java.util.HashSet;

public class MMCC2 {
	
	public static void main(String[] args) {  
	       int[][] arr = {{1,11,23,12,32,12,12,20}};    
	     countNumbers(arr); 
	    } 

	
	
	public static void countNumbers(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int n = arr[i][0];
			int m = arr[i][1];
			int count = 0;
			for (int num = n; num <= m; num++) {
				if (hasUniqueDigits(num)) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

	private static boolean hasUniqueDigits(int num) {
		HashSet<Integer> digits = new HashSet<>();
		while (num > 0) {
			int digit = num % 10;
			if (digits.contains(digit)) {
				return false;
			}
			digits.add(digit);
			num /= 10;
		}
		return true;
	}

}
