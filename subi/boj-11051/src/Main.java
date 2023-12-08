import java.util.Scanner;

public class Main {

	static int arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		arr = new int[n + 1][n + 1]; //조합은 1부터로

		System.out.println(Combination(n, k));
	}

	private static int Combination(int n, int k) {
		if (n == k || k == 0) {
			return arr[n][k] = 1;
		}
		if (arr[n][k] != 0) {
			return arr[n][k];
		}

		return arr[n][k] = (Combination(n - 1, k - 1) + Combination(n - 1, k)) % 10007;

	}
}