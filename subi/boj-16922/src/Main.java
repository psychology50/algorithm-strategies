import java.util.Scanner;

public class Main {
	static int N;
	static int num[];
	static int sum[];
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[] {1, 5, 10, 50};
		sum = new int[10000];
		pick(0, 0, 0);
		System.out.println(res);
	}

	static void pick(int cnt, int idx, int s) {
		if (cnt == N) {
			if (sum[s] == 0) {
				sum[s] = 1;
				res++;
			}
			return;
		}

		for (int i = idx; i < 4; i++) {
			pick(cnt + 1, i, s + num[i]);
		}
	}
}