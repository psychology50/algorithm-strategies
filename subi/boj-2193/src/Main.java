import java.util.Scanner;

public class Main {
	static long[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		dp = new long[n + 1][2];

		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][1] = dp[i - 1][0];
		}

		System.out.println(dp[n][1] + dp[n][0]);

	}
}