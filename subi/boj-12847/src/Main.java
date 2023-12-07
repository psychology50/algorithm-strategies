import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int pay[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		pay = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pay[i] = Integer.parseInt(st.nextToken());
		}

		long sum = 0, max = 0;

		for (int i = 0; i < m; i++) {
			sum += pay[i];
		}

		max = Math.max(sum, max);

		for (int i = m; i < n; i++) {
			int j = i - m;
			sum -= pay[j];
			sum += pay[i];
			max = Math.max(sum, max);
		}

		System.out.println(max);


	}
}