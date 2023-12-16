import java.util.Scanner;

public class Main {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
	}

	private static void dfs(int number, int jarisu) { //N==2면
		//2,1 들어옴
		if (N == jarisu) { //4자리인 수 중에서
			if (isPrime(number)) { //소수이면
				System.out.println(number);
			}
			return;
		}

		for (int i = 1; i < 10; i++) {
			if (i % 2 == 0) {
				continue;
			}
			//21,23,25.27,29에 대해서
			if (isPrime(number * 10 + i)) {
				dfs(number * 10 + i, jarisu + 1);
			}
		}
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i <= (num / 2); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}