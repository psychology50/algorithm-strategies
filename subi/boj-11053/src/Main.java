import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		dp = new int[N];
		A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.fill(dp, 1);

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		int max = 0;
		for (int n : dp) {
			max = Math.max(n, max);
		}

		System.out.println(max);

	}
}