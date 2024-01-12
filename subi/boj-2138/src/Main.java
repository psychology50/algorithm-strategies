import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, cnt1, cnt2;
	static char[] AInput;
	static char[] BInput;
	static char[] Output;

	static int[] dx = {-1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		String s1 = br.readLine();
		String s2 = br.readLine();

		AInput = s1.toCharArray();
		BInput = s1.toCharArray();
		Output = s2.toCharArray();

		int result = Integer.MAX_VALUE;

		changeBulb(AInput, 0);
		cnt1++;

		for (int i = 1; i < N; i++) {
			if (AInput[i - 1] != Output[i - 1]) {
				changeBulb(AInput, i);
				cnt1++;
			}
			if (BInput[i - 1] != Output[i - 1]) {
				changeBulb(BInput, i);
				cnt2++;
			}
		}

		if (AInput[N - 1] == Output[N - 1]) {
			result = Math.min(result, cnt1);
		}


		if (BInput[N - 1] == Output[N - 1]) {
			result = Math.min(result, cnt2);
		}

		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}


	}

	private static void changeBulb(char[] input, int index) {
		for (int k = 0; k < 3; k++) {
			int nowX = index + dx[k];
			if (nowX >= 0 && nowX < N) {
				if (input[nowX] == '0') {
					input[nowX] = '1';
				} else {
					input[nowX] = '0';
				}
			}
		}
	}


}