import java.math.BigInteger;
import java.util.Scanner;


public class Main {

	static BigInteger cache[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		cache = new BigInteger[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				cache[i][j] = BigInteger.ZERO;
			}
		}

		System.out.println(Combination(n, k));
	}

	private static BigInteger Combination(int n, int k) {
		if (n == k || k == 0) {
			return cache[n][k] = BigInteger.valueOf(1);
		}

		if (cache[n][k].compareTo(BigInteger.ZERO) != 0) {
			return cache[n][k];
		}

		return cache[n][k] = Combination(n - 1, k - 1).add(Combination(n - 1, k));
	}


}