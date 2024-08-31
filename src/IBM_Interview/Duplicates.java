package IBM_Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Duplicates {
	public static void main(String[] args) {
		Integer m[] = { 1, 2, 3, 4, 5, 6, 3, 2, 1, 4 };
		duplicateCharFromString("For Loop Tee");
		System.out.println();
		duplicateElementsFromList(m);
	}

	public static void duplicateCharFromString(String s) {
		int count;
		// converts given String into charecter array
		char[] str = s.toCharArray();

		System.out.print("Duplicate chars are : ");
		// Count each chars present in the string
		for (int i = 0; i < str.length; i++) {
			count = 1;
			for (int j = i + 1; j < str.length; j++) {
				if (str[i] == str[j] && str[i] != ' ') {
					count++;
					// set str[j] to 0 to avoid printing visited chars
					str[j] = '0';
				}
			}
			// A chars is considered as duplicate if count is grater then 1
			if (count > 1 && str[i] != '0') {
				System.out.print(str[i] + " ");
			}

		}

	}

	public static void duplicateElementsFromList(Integer a[]) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(a));

		HashSet<Integer> firstSet = new HashSet<Integer>();
		HashSet<Integer> finalSet = new HashSet<Integer>();

		for (Integer array : arrayList) {
			if (!firstSet.add(array)) {
				finalSet.add(array);
			}
		}
		System.out.println("Duplicate ingeters from the is is : " + finalSet);

	}

}
