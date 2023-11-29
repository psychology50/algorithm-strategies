import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		long result = k;

		for (int i = 0; i < n; i++) {
			//result += p % 1000000007
			//result = (result * (p % 1000000007)) % 1000000007;
			result *= p;
			result %= 1000000007;
		}

		System.out.println(result);

	}
}