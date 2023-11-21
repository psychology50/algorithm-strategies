import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int count = 1, startIndex = 1, endIndex = 1, sum = 1;

		while (endIndex < input) {
			if (sum < input) {
				endIndex++;
				sum += endIndex;
			} else if (sum > input) {
				sum -= startIndex;
				startIndex++;
			} else {
				count++;
				endIndex++;
				sum += endIndex;
			}
		}
		System.out.println(count);
	}
}