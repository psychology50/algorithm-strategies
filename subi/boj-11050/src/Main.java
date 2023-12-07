import java.io.IOException;
import java.util.Scanner;


public class Main {

	static int cache[][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		cache = new int[n + 1][k + 1];
		int result = Combination(n, k);
		System.out.println(result);
	}

	private static int Combination(int n, int k) {
		if (n == k || k == 0) {
			return cache[n][k] = 1;
		}

		if (cache[n][k] != 0) {
			return cache[n][k];
		}

		return cache[n][k] = Combination(n - 1, k - 1) + Combination(n - 1, k);
	}


}