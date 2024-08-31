package com.SeleniumTest.Automation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SelectsClasses {
	public static void main(String[] args) throws FileNotFoundException {
		String ss = "tomtom";
		System.out.println(ss.length());

		String sp = "12";
		Integer s3 = Integer.parseInt(sp);
		System.out.println("count : " + (s3 + 4));


		//File 
		String path = "C:\\Users\\zaman\\OneDrive\\Desktop\\HH.txt";
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			System.out.print(scanner.nextLine());
		}
		


	    	}
}
