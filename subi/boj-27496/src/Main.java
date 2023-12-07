import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static double alcol[];
	static double sum[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		alcol = new double[n];
		sum = new double[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int alco = Integer.parseInt(st.nextToken());
			alcol[i] = alco;
		}

		sum[0] = alcol[0];

		for (int i = 1; i < l; i++) {
			sum[i] = sum[i - 1] + alcol[i];
		}

		for (int i = l; i < n; i++) {
			int j = i - l;
			sum[i] = sum[i - 1] - alcol[j];
			sum[i] = sum[i] + alcol[i];
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (sum[i] >= 129 && sum[i] <= 138) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}
}