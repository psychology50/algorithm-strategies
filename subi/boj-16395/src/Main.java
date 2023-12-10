import java.util.Scanner;

public class Main {

	static int arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			arr[0][i] = 1;
			arr[i][0] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				fibo(i, j);
			}
		}


		System.out.println(arr[n - k][k - 1]);

	}

	private static int fibo(int n, int r) {

		return arr[n][r] = arr[n][r - 1] + arr[n - 1][r];
	}
}