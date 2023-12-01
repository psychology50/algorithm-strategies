import java.util.Scanner;

public class Main {
	static int D[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		D = new int[n + 1];

		//알 수 있는 값을 미리 초기화 시켜 놓자.
		D[0] = 1;
		D[1] = 1;
		//1넣었을 때 D[2]를 초기화 해줘서 인덱스 에러 발생
		//D[2] = 2;

		for (int i = 2; i <= n; i++) {
			tiling(i);
		}

		//같은 거
		System.out.println(D[n]);

	}

	private static int tiling(int n) {

		D[n] = (D[n - 1] + D[n - 2]) % 10007;

		return D[n];
	}
}