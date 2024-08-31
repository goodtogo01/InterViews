package Emphasis_InterView;

public class MissingNumber {
	public static void main(String[] args) {
		// for single missing
		int m[] = { 1, 3, 4, 5, 6 };
		int n = m.length + 1;
		System.out.println("Single Missing : " + oneNum(m, n));

		// original array
		int[] array = { 0, 5, 6, 0, 4, 2, 0 };
		multi(array);
		
		fizzBuzz(12);

	}

	public static int oneNum(int a[], int n) {
		int sum = n * (n + 1) / 2;

		for (int i = 0; i < a.length; i++) {
			sum = sum - a[i];
		}
		return sum;
	}

	public static void multi(int[] arr) {
		int nArray[] = new int[arr.length];
		for (int i : arr) {
			nArray[i] = 1;
		}
		System.out.print("Multi Missing: ");
		for (int i = 1; i < nArray.length; i++) {
			if (nArray[i] == 0) {
				System.out.print(i + ", ");
			}
		}
	}

	public static void fizzBuzz(int n) {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}

		}
	}

}
