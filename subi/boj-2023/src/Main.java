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

	private static void dfs(int number, int jarisu) { //(21,2)들어오면
		//n=2이면
		if (N == jarisu) {
			if (isPrime(number)) { //21이 소수인지 판단하고 소수면
				System.out.println(number);
			}
			return;//빠져나오고 3으로 이동
		}

		//자리수가 2이상부터 실행됌
		for (int i = 1; i < 10; i++) {
			if (i % 2 == 0) {
				continue;
			}
			//1,3,5,7,9 이면
			if (isPrime(number * 10 + i)) { //21,23,25,27,29
				dfs(number * 10 + i, jarisu + 1); //(21,2)가 들어감
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