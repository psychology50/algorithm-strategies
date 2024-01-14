import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] price = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			int max = price[N - 1];
			long profit = 0;

			for (int i = N - 2; i >= 0; i--) {
				if (max > price[i]) {
					profit += max - price[i];
				} else {
					max = price[i];
				}
			}

			System.out.println(profit);

		}
	}
}