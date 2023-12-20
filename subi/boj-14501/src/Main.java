import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static int[] T;
	static int[] P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 2];
		dp[n + 1] = 0;
		T = new int[n + 1];
		P = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = n; i >= 1; i--) {
			if (i + T[i] > n + 1) {
				dp[i] = dp[i + 1];
			} else {
				dp[i] = Math.max(dp[i + 1], dp[i + T[i]] + P[i]);
			}
		}

		System.out.println(dp[1]);

	}
}