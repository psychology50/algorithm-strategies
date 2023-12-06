import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int sum = facto(n);
		System.out.println(sum);

	}

	private static int facto(int n) {
		if (n <= 1) return 1;    // 재귀 종료조건
		return n * facto(n - 1);
	}
}