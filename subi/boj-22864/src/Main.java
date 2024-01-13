import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int T = 24;
		int cnt = 0;
		int myA = 0;

		if (A > M) {
			System.out.println(0);
			return;
		}

		while (true) {
			if (T == 0) break;
			if (myA + A <= M) {
				cnt++;
				myA += A;
			} else {
				myA -= C;
				if (myA < 0) myA = 0;
			}
			T--;
		}

		System.out.println(cnt * B);

	}
}