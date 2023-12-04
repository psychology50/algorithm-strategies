import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int cnt = 0;

		while (b != a) {
			if (b < a) {
				System.out.println(-1);
				return;
			}

			String str = String.valueOf(b);

			if (b % 2 == 0) {
				cnt++;
				b /= 2;
				if (a == b) {
					System.out.println(cnt + 1);
					return;
				}
			} else if (str.charAt(str.length() - 1) == '1') {
				cnt++;
				str = str.substring(0, str.length() - 1);
				b = Integer.parseInt(str);

				if (a == b) {
					System.out.println(cnt + 1);
					return;

				}
			} else {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(cnt + 1);

	}
}