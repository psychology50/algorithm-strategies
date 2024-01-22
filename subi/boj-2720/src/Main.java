import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] coin = {25, 10, 5, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t = 0; t < test; t++) {
			int change = Integer.parseInt(br.readLine());
			int k = 0;
			int[] cnt = new int[4];
			while (change > 0) {
				if (change >= coin[k]) {
					change -= coin[k];
					cnt[k]++;
				} else {
					k++;
				}
			}

			for (int n : cnt) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
}