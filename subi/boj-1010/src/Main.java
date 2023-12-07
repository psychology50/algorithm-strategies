import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int cache[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			cache = new int[30][30];
			int result = findNum(m, n);
			System.out.println(result);
		}
	}

	private static int findNum(int m, int n) {

		if (m == n || n == 0) {
			cache[m][n] = 1;
			return 1;
		}

		if (cache[m][n] > 0) return cache[m][n];

		//주의!
		return cache[m][n] = findNum(m - 1, n - 1) + findNum(m - 1, n);

	}

}