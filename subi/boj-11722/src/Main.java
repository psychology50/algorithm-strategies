import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N = 0;
	static int[] A;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new int[N];
		Arrays.fill(dp, 1);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (A[j] > A[i]) {
					max = Math.max(dp[j], max);
				}
			}
			dp[i] = max + 1;
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}