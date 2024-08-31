package CoreJava;

public class ReverseInteger {
	public static void main(String[] args) {
		reversInt_01(632);
		palindromWithPalindrom(565);
	}

	public static void reversInt_01(int n) {
		System.out.println("************  Reverse Number *******************");
		int temp = n, sum = 0, rem = 0;
		System.out.println("Actual Number is : " + temp);

		while (temp != 0) {
			rem = temp % 10;
			sum = sum * 10 + rem;
			temp = temp / 10;
		}
		System.out.println("The reveers int is : " + sum);
	}
	public static void palindromWithPalindrom(int n) {
		System.out.println("\n************  Palindrom with Integer *******************");
		int temp = n, sum = 0, rem = 0;
		System.out.println("Actual Number is : " + temp);

		while (temp != 0) {
			rem = temp % 10;
			sum = sum * 10 + rem;
			temp = temp / 10;
		}
		System.out.println("The reveers int is : " + sum);
		if (n == sum) {
			System.out.println("This is a Palindrom.");
		}else {
			System.out.println("This is not a palindrom.");
		}
	}


}
