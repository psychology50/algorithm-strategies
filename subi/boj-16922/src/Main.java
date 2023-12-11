import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] num = {1, 5, 10, 50};
	static boolean[] dp = new boolean[1001];
	static int result = 0, N = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pick(N, 0, 0);
		System.out.println(result);
	}

	private static void pick(int n, int index, int sum) {
		if (n == 0) {
			if (dp[sum] == false) {
				result++;
				dp[sum] = true;
			}
			return;
		}

		for (int i = index; i < 4; i++) {
			pick(n - 1, i, sum + num[i]);
		}

	}


}