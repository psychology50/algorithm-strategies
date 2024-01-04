import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] A;
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		long k = Long.parseLong(st.nextToken());

		A = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			k -= A[i];
			if (k < 0) {
				System.out.println(i + 1);
				return;
			}
		}

		if (!check) {
			for (int i = n - 1; i >= 0; i--) {
				k -= A[i];
				if (k < 0) {
					System.out.println(i + 1);
					return;
				}
			}
		}


	}
}