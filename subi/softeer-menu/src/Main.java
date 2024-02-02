import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[] Menu;
	static int[] Button;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Menu = new int[M];
		Button = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			Menu[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Button[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = start + M;

		if (N < M) {
			System.out.println("normal");
			return;
		}

		while (end <= N) {
			int k = 0;
			for (int i = start; i < end; i++) {
				if (Button[i] == Menu[k]) {
					k++;
				}
			}
			if (k == M) {
				System.out.println("secret");
				return;
			}
			start++;
			end = start + M;
		}

		System.out.println("normal");


	}
}
