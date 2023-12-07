import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new int[n + k - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < k - 1; i++) {
			arr[n + i] = arr[i];
		}

		long sum = 0, max = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		max = Math.max(sum, max);

		for (int i = k; i < arr.length; i++) {
			int j = i - k;
			sum -= arr[j];
			sum += arr[i];
			max = Math.max(sum, max);
		}

		System.out.println(max);

	}
}