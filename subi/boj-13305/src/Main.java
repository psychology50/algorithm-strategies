import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int d[];
	static int p[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		d = new int[n - 1];
		p = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int end = n - 1;

		for (int i = 0; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				if (p[i] <= p[j]) {
					p[j] = p[i];
				}
			}
		}

		for (int i = 0; i < end; i++) {
			sum += (p[i] * d[i]);
		}

		System.out.println(sum);
	}
}