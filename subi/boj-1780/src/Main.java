import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N = 0;
	static int[][] A;
	static int minus = 0;
	static int zero = 0;
	static int plus = 0;


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		findPartition(0, 0, N);

		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

	private static void findPartition(int row, int col, int size) {

		if (checkSame(row, col, size)) {
			if (A[row][col] == 1) plus++;
			else if (A[row][col] == 0) zero++;
			else if (A[row][col] == -1) minus++;
			return;
		}

		int newSize = size / 3;

		findPartition(row, col, newSize); //0.0
		findPartition(row, col + newSize, newSize); //0.3
		findPartition(row, col + 2 * newSize, newSize); //0.6

		findPartition(row + newSize, col, newSize); //3.0
		findPartition(row + 2 * newSize, col, newSize); //6.0

		findPartition(row + newSize, col + newSize, newSize); //3.3
		findPartition(row + 2 * newSize, col + 2 * newSize, newSize); //6.6

		findPartition(row + 2 * newSize, col + newSize, newSize); //6.3
		findPartition(row + newSize, col + 2 * newSize, newSize); //3.6

	}

	private static boolean checkSame(int row, int col, int size) {

		int color = A[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (color != A[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}