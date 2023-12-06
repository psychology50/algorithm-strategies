import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] bear;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int ice, bucket = 0;

		bear = new int[4000001];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ice = Integer.parseInt(st.nextToken());
			bucket = Integer.parseInt(st.nextToken());
			bear[bucket] = ice;
		}

		long sum = 0, result = 0;

		for (int i = 0; i < (k * 2) + 1; i++) {
			sum += bear[i];
		}

		result = Math.max(sum, result);

		for (int i = (k * 2) + 1; i < bear.length; i++) {
			int j = i - ((k * 2) + 1);
			sum -= bear[j];
			sum += bear[i];
			result = Math.max(sum, result);
		}

		System.out.println(result);

	}
}