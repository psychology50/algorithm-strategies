import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static char[] c1;
	static char[] c2;
	static int[][] dp;
	static ArrayList<Character> Path = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		c1 = s1.toCharArray();
		c2 = s2.toCharArray();
		dp = new int[s1.length()][s2.length()];

		if (c1[0] == c2[0]) {
			dp[0][0] = 1;
		} else {
			dp[0][0] = 0;
		}
		//0행
		for (int i = 1; i < s1.length(); i++) {
			if (c1[i] == c2[0]) {
				dp[i][0] = 1;
			} else {
				dp[i][0] = dp[i - 1][0];
			}
		}
		//0열
		for (int i = 1; i < s2.length(); i++) {
			if (c1[0] == c2[i]) {
				dp[0][i] = 1;
			} else {
				dp[0][i] = dp[0][i - 1];
			}
		}

		for (int i = 1; i < s1.length(); i++) {
			for (int j = 1; j < s2.length(); j++) {
				if (c1[j] == c2[i]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(dp[c1.length - 1][c2.length - 1]);
		getText(c1.length - 1, c2.length - 1);

		for (int i = Path.size() - 1; i >= 0; i--) {
			System.out.println(Path.get(i));
		}

	}

	private static void getText(int r, int c) {
		if (r == 0 || c == 0) {
			return;
		}
		if (c1[r - 1] == c2[c - 1]) {
			Path.add(c1[r - 1]);
			getText(r - 1, c - 1);
		} else {
			if (dp[r - 1][c] > dp[r][c - 1]) {
				getText(r - 1, c);
			} else {
				getText(r, c - 1);
			}
		}
	}
}