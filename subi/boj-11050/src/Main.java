import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int Combination[][] = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			Combination[i][0] = 1; //아무것도 안 뽑는 경우 = 1가지
			Combination[i][i] = 1;
			Combination[i][1] = i;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) { // 고르는 수의 개수가 전체 개수를 넘을 수 없다.
				Combination[i][j] = Combination[i - 1][j] + Combination[i - 1][j - 1];
			}
		}

		System.out.println(Combination[n][r]);


	}
}