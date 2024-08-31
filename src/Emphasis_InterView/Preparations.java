package Emphasis_InterView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Preparations {
	static int f[] = { 9, 2, 1, 5, 4, 8, 9, 66, 5, 4 };
	static String ltr[]= {"A", "F", "T", "L", "C", "M"};
	static String q = "BANAB";
	public static void main(String[] args) {
		larg(f);
		vslo(ltr); 
		listInt();
		pal(q);
	}

	public static void larg(int n[]) {
		int max = Arrays.stream(n).max().getAsInt();
		int min = Arrays.stream(n).min().getAsInt();
		double avg = Arrays.stream(n).average().getAsDouble();
		System.out.println("Max : "+max+"\nMin : "+min+"\nAvg No: "+avg);
	}

	public static void vslo(String t[]) {
		Arrays.sort(t);
		System.out.println(Arrays.toString(t));
	}
	
	public static void listInt() {
		List<Integer> in = new ArrayList<>(
				Arrays.asList(9,2,1,4,5,4,5,6));
		
		 Collections.sort(in);
		System.out.println("After Sort :"+in);
		Collections.reverse(in);
		System.out.println("After reverse : "+in);
	
	}
	
	public static void pal(String m) {
		
		char c[] = m.toCharArray();
		String rev = "";
		
		for (int i = c.length -1; i>=0; i--) {
			rev +=c[i];
		}
		if(rev.equals(m)) {
			System.out.println(m +" Is a Palindrom");
		}else {
			System.out.println(m +" is Not a Palindrom");
		}
		
		
		
		
	}
}
