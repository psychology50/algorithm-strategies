import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] A;
	static int[] dpL;
	static int[] dpR;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		A = new int[n];
		dpL = new int[n];
		dpR = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		dpL[0] = A[0];
		dpR[n - 1] = A[n - 1];

		int result = dpL[0];
		for (int i = 1; i < n; i++) {
			dpL[i] = Math.max(A[i], A[i] + dpL[i - 1]);
			result = Math.max(result, dpL[i]);
		}

		for (int i = n - 2; i >= 0; i--) {
			dpR[i] = Math.max(A[i], A[i] + dpR[i + 1]);
		}

		for (int i = 1; i < n - 1; i++) {
			int temp = dpL[i - 1] + dpR[i + 1];
			result = Math.max(temp, result);
		}
		System.out.println(result);


	}
}