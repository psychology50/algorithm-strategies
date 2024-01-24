import java.util.Scanner;

public class Main {
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();

		for (int t = 0; t < test; t++) {

			int n = sc.nextInt();

			dp = new int[n + 1];

			dp[0] = 1;
			dp[1] = 1;

			for (int i = 2; i <= n; i++) {
				if (i == 2) {
					dp[i] = 2;
					continue;
				}
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}

			System.out.println(dp[n]);

		}

	}
}