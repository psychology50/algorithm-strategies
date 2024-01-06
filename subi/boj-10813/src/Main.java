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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = i + 1;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int temp = A[n1 - 1];
			A[n1 - 1] = A[n2 - 1];
			A[n2 - 1] = temp;
		}

		for (int i = 0; i < N; i++) {
			System.out.print(A[i] + " ");
		}

	}
}