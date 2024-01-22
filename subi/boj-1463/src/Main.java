import java.util.Scanner;

public class Main {
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n + 1];

		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i <= n; i++) {
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
			}
			if (n % 2 == 0) {
				dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
			} else {
				dp[i] = dp[i - 1] + 1;
			}
		}

		System.out.println(dp[n]);

	}
}