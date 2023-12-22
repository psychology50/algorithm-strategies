import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			long max = arr[n - 1];
			long profit = 0;

			for (int i = n - 2; i >= 0; i--) {
				if (arr[i] < max) {
					profit -= arr[i];
					profit += max;
				} else {
					max = arr[i];
				}
			}

			System.out.println("#" + t + " " + profit);

		}
	}
}