import java.util.Scanner;

public class Main {
	static int D[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		D = new int[n + 1];

		//초기화
		for (int i = 0; i <= n; i++) {
			D[i] = -1;
		}

		//가장 작은 문제 = 이미 아는 값
		D[0] = 0;
		D[1] = 1;

		fibo(n);

		System.out.println(D[n]);
	}

	public static int fibo(int n) {
		if (D[n] != -1) { //기존에 계산한 문제가 있을 경우 바로 리턴 = 메모이제이션 = 시간 복잡도 단축
			return D[n];
		}
		return D[n] = fibo(n - 1) + fibo(n - 2);
		//구한 갑을 바로 리턴하지 않고 D배열에 저장한 후에 D배열을 리런시켜줘야 계속 값이 D 배열에 저장된다.
	}
}