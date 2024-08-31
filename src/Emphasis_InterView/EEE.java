package Emphasis_InterView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.Set;

public class EEE {

	public static void main(String[] args) throws IOException {
//		String[] arr = { "Algorithms", "String", "Integer", "Integer", "Algorithms", "String", "Integer", "Algorithms",
//				"String", "Algorithms" };
	String s = "Welcome this this world of Mine of mine ";
	numberOfWords(s);
//		System.out.println();
//		numberOfWords2(s);
//		System.out.println();
//		numberOfWords3(s);
//		System.out.println();
//		repeatedWords1(s);
//		System.out.println("Most Frequent words are : " + findFrequentWord(arr));
//		System.out.print(primeCheck(4));

//		convertFromWordsToDigits();
		//inputss();

	}

	public static void inputss() {
		/*
		 * We use the integers , , and to create the following series:
		 * 
		 * You are given queries in the form of , , and . For each query, print the
		 * series corresponding to the given , , and values as a single line of
		 * space-separated integers.
		 */
		
		Scanner scanner = new Scanner(System.in);         
		// Read the number of queries    
		System.out.println("Enter Number : ");
		int q = scanner.nextInt();       
		 scanner.nextLine();  
		 
		// Process each query        
		for (int i = 0; i < q; i++) {            
		// Read the values for the current query            
		int a = scanner.nextInt();            
		int b = scanner.nextInt(); 
		int n = scanner.nextInt();            
		scanner.nextLine();             
		// Generate and print the series            
		for (int j = 0; j < n; j++) {                
		int term = a;   
	 
		for (int k = 0; k <= j; k++) {                    
		term += Math.pow(2, k) * b;               
		 }                 
		System.out.print(term + " ");            
		}            
		 System.out.println();       
		 }         
		scanner.close();   

	}

	public static long countSubarrays(List<Integer> numbers, int k) {
		long count = 0;
		int n = numbers.size();
		int[] prefixSum = new int[n];
		prefixSum[0] = numbers.get(0) % k;
		for (int i = 1; i < n; i++) {
			prefixSum[i] = (prefixSum[i - 1] + numbers.get(i)) % k;
		}
		Map<Integer, Integer> reminderCount = new HashMap<>();
		for (int sum : prefixSum) {
			reminderCount.put(sum, reminderCount.getOrDefault(sum, 0) + 1);
		}
		for (int countOfReminder : reminderCount.values()) {
			count += (countOfReminder * (countOfReminder - 1)) / 2;
		}
		count += reminderCount.getOrDefault(0, 0);
		return count;

	}

	public static void numberOfWords(String words) {
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		String[] str = words.split(" ");
		System.out.print("Solutions One : ");
		for (String word : str) {
			if (hashMap.containsKey(word))
				hashMap.put(word, hashMap.get(word) + 1);
			else
				hashMap.put(word, 1);
		}
		System.out.print(hashMap);

	}

	public static void numberOfWords2(String str) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		String[] words = str.split(" ");
		System.out.print("Solutions Two : ");
		for (String word : words) {
			Integer integer = map.get(word);

			if (integer == null)
				map.put(word, 1);
			else {
				map.put(word, integer + 1);
			}
		}
		System.out.print(map);

	}

	public static void numberOfWords3(String str) {
		// Remove white space
		str = str.trim();

		// split array into in an array
		String[] s = str.split("\\s+");

		// Create hashmap to store word count
		Map<String, Integer> map = new HashMap<String, Integer>();

		// Iterare over each word in array
		for (String word : s) {
			// if the word is already there in the hashmap, increment its count
			if (map.containsKey(word)) {
				int count = map.get(word);
				map.put(word, count + 1);
			} else {
				// otherwise add the word to the hashmap with a count of 1
				map.put(word, 1);
			}
		}
		// print the word count
		System.out.print("Solutions Three : ");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.print(entry.getKey() + " => " + entry.getValue() + ", ");
		}

	}

	public static void repeatedWords1(String str) {
		// Remove white space
		str = str.trim();

		// split array into in an array
		String[] s = str.split("\\s+");

		// Create hashmap to store word count
		Map<String, Integer> map = new HashMap<String, Integer>();

		// Iterare over each word in array
		for (String word : s) {
			// if the word is already there in the hashmap, increment its count
			if (map.containsKey(word)) {
				int count = map.get(word);
				map.put(word, count + 1);
			} else {
				// otherwise add the word to the hashmap with a count of 1
				map.put(word, 1);
			}
		}
		// Find the maximum count
		int maxCount = 0;
		for (int count : map.values()) {

			if (count > maxCount) {
				maxCount = count;
			}
		}

		// find words with max count
		List<String> mostRepeatedWords = new ArrayList<String>();

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == maxCount) {
				mostRepeatedWords.add(entry.getKey());
			}
		}
		// print the word count

		System.out.print("Most Repeated word is : ");
		for (String word : mostRepeatedWords) {

			System.out.println(word + ", ");
		}

	}

	public static String findFrequentWord(String[] input) {

		System.out.println("Input: " + Arrays.toString(input));
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < input.length; i++) {
			String word = input[i];
			int count = map.getOrDefault(word, 0);
			map.put(word, count + 1);
		}
		String frequentWord = null;
		int count = 0;
		for (String key : map.keySet()) {
			if (count < map.get(key)) {
				count = map.get(key);
				frequentWord = key;
			}
		}
		return frequentWord;
	}

	public static boolean primeCheck(int number) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		number = sc.nextInt();
		if (number <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;

			}
		}
		return true;
	}

	private static final Map<String, String> wordToDigit = new HashMap<>();
	static {
		wordToDigit.put("zero", "0");
		wordToDigit.put("one", "1");
		wordToDigit.put("two", "2");
		wordToDigit.put("three", "3");
		wordToDigit.put("four", "4");
		wordToDigit.put("five", "5");
		wordToDigit.put("six", "6");
		wordToDigit.put("seven", "7");
		wordToDigit.put("eight", "8");
		wordToDigit.put("nine", "9");
	}

	public static void convertFromWordsToDigits() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter your words : ");
		String str = sc.nextLine();
		String[] arr = str.split(" ");
		String ans = "";
		int i = 0;
		Map<String, String> wordToDigit = new HashMap<String, String>();
		wordToDigit.put("zero", "0");
		wordToDigit.put("one", "1");
		wordToDigit.put("two", "2");
		wordToDigit.put("three", "3");
		wordToDigit.put("four", "4");
		wordToDigit.put("five", "5");
		wordToDigit.put("six", "6");
		wordToDigit.put("seven", "7");
		wordToDigit.put("eight", "8");
		wordToDigit.put("nine", "9");

		while (i < arr.length) {
			if (arr[i].equals("double")) {
				ans = ans + wordToDigit.get(arr[i + 1]) + wordToDigit.get(arr[i + 1]);
				i++;
			} else if (arr[i].equals("triple")) {
				ans = ans + wordToDigit.get(arr[i + 1]) + wordToDigit.get(arr[i + 1])+ wordToDigit.get(arr[i + 1]);
				i++;
			} else {
				ans = ans + wordToDigit.get(arr[i]);
			}
			i++;
		}
		System.out.println("Your inputs :  [ "+str+" ] ");
		System.out.println("The Converted digits are : "+ans);
	}

}
