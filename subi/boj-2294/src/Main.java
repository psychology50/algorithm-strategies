import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int coin[];
	static int dp[];
	static int n = 0, k = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		coin = new int[n];
		dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		Arrays.fill(dp, 100001); //최소값 계산 세팅
		dp[0] = 0;

		int result = findMinCoins();
		System.out.println(result);

	}

	private static int findMinCoins() {

		for (int amount = 1; amount < k + 1; amount++) {
			for (int c : coin) {
				if (amount >= c) {
					dp[amount] = Math.min(dp[amount], dp[amount - c] + 1);
				}
			}
		}

		// 100001이 채워져 있으면!
		return dp[k] > k ? -1 : dp[k];

	}

}