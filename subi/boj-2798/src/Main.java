import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		A = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0;

		for (int i = 0; i <= n - 3; i++) {
			for (int j = i + 1; j <= n - 2; j++) {
				for (int k = j + 1; k <= n - 1; k++) {
					int sum = A[i] + A[j] + A[k];
					if (sum <= m) max = Math.max(sum, max);
				}
			}
		}


		System.out.println(max);


	}
}