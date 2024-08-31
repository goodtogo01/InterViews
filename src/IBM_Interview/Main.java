package IBM_Interview;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		String originalString = "HelloWorld";
		int index = 5;
		// Create a StringBuilder object with the original string
		StringBuilder stringBuilder = new StringBuilder(originalString);
		// Insert a white space at the specified index
		stringBuilder.insert(index, " ");
		// Get the modified string
		String modifiedString = stringBuilder.toString();
		//System.out.println("Modified string: " + modifiedString);

		

	}
}
