package CoreJava;

import java.util.Arrays;
import java.util.Collections;

public class IBM_Questions {
	public static void main(String[] args) {
		String inString = "abc de"; // "edc ba"
		

		String removeSpace = inString.replace(" ", "");
		System.out.println(removeSpace);
		StringBuffer sb = new StringBuffer(inString);
		StringBuffer res = sb.reverse();
		System.out.println(res.toString());

System.out.println(ss(inString));
		

		


	}

	public static String reverseWord(String str) {

		String words[] = str.split("\\s");
		String reverseWord = " ";
		for (String w : words) {
			StringBuilder sb = new StringBuilder(w);
			StringBuilder nn = sb.reverse();
			reverseWord += nn.toString() + " ";
//	        sb.reverse();  
		}
		return reverseWord.trim();
	}
	public static String addSpace(String s, int[] spaces) {

		int i = 0; // Iterate for spaces
		int j = 0; // Iterate for actualString
		int k = 0; // Iterate for final output

		char[] cString = new char[s.length() + spaces.length]; 
		
		// Append length and spaces
		while (i < spaces.length && j < s.length()) {
			int insertionsIndex = spaces[i];

			while (j < insertionsIndex && j < s.length()) {
				cString[k] = s.charAt(j);
				k++;
				j++;
			}
			// add space
			cString[k] = ' ';
			k++;
			j++;
		}
		while (j < s.length()) {
			cString[k] = s.charAt(j);
			k++;
			j++;
		}

		return new String(cString);

	}
	public static void des(String str) {
		char[] arr = str.toCharArray();
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]);
//			//System.out.println();
//			Arrays.sort(arr);
//		}
		for (int i = arr.length - 1; i >= 0; i--) 
//			System.out.print(arr[i]);
//			System.out.println();
		
		System.out.println(arr);

	}

	public static String ss(String str) {
		String[] words = str.split(" ");         
		StringBuilder sortedString = new StringBuilder();         
		 for (String word : words) {             
		char tempArray[] = word.toCharArray();            
		 Arrays.sort(tempArray);              
		for (int i = tempArray.length-1; i>=0; i--)                 
		sortedString.append(tempArray[i]);                          
		sortedString.append(" ");        
		 }          
		return sortedString.toString().trim();   

	}
}