import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[][] dp = new long[100001][4];
	static int MOD = 1000000009;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
		}

		for (int t = 0; t < test; t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % MOD);
		}
	}
}