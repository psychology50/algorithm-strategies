import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] price;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		price = new int[n + 1];
		dp = new int[n + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			dp[i] = price[i];
			for (int p = 1; p <= i; p++) {
				dp[i] = Math.min(dp[i], price[p] + dp[i - p]);
			}
		}

		System.out.println(dp[n]);
	}
}