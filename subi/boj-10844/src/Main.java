import java.util.Scanner;

public class Main {
	static long[][] dp;
	static long mod = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n + 1][10];

		dp[0][0] = 0;
		dp[1][0] = 0;

		for (int j = 1; j <= 9; j++) {
			dp[0][j] = 0;
			dp[1][j] = 1;
		}

		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][9] = dp[i - 1][8];
			for (int j = 1; j <= 8; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
			}
		}

		long result = 0;
		for (int j = 0; j <= 9; j++) {
			result = result + dp[n][j] % mod;
		}

		System.out.println(result);
	}
}