import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long i = 1;

		if (n == 1) {
			System.out.println(1);
			return;
		}

		while (n >= i) {
			n -= i;
			i++;
		}

		System.out.println(i - 1);
	}
}