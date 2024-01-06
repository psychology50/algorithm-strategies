import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] A = new boolean[101][101];
	static int area = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (!A[i][j]) {
						A[i][j] = true;
						area++;
					}
				}
			}
		}

		System.out.println(area);


	}
}