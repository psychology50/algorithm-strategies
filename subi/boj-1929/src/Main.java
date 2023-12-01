import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[m + 1];

		//초기화로 어차피 인덱스 0번은 0이 되어있음.

		for (int i = 2; i <= m; i++) {
			arr[i] = i;
		}

		//1은 소수가 아니므로 탐색 안함
		for (int i = 2; i <= Math.sqrt(m); i++) {
			//소수이면 탐색 중지
			if (arr[i] == 0) continue;

			for (int j = i + i; j <= m; j = j + i) {
				arr[j] = 0;
			}
		}

		for (int i = n; i <= m; i++) {
			if (arr[i] != 0) {
				System.out.println(arr[i]);
			}
		}

	}
}