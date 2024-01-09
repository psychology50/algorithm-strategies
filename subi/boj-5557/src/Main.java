import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] A;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		dp = new long[N][21];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		dp[0][A[0]] = 1;


		for (int i = 1; i <= N - 2; i++) {
			for (int j = 0; j <= 20; j++) {
				if (dp[i - 1][j] != 0) {
					int plus = j + A[i];
					int minus = j - A[i];
					if (plus >= 0 && plus <= 20) dp[i][plus] += dp[i - 1][j];
					System.out.println(j);
					System.out.println(dp[i - 1][j]);
					if (minus >= 0 && minus <= 20) dp[i][minus] += dp[i - 1][j];
				}
			}
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j <= 20; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(dp[N - 2][A[N - 1]]);

	}

}