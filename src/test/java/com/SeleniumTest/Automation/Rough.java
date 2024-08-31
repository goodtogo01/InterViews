package com.SeleniumTest.Automation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Rough {
	public static void main(String[] args) {
 
		String[] ab= {"K", "H", "O", "S", "R", "U"};
		Arrays.sort(ab);
		System.out.println(Arrays.toString(ab));
		Arrays.sort(ab, Collections.reverseOrder());
		System.out.println(Arrays.toString(ab));
	}
}
