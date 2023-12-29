import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] A;
	//오하좌상
	static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
	static int C, R, sitNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		sitNum = Integer.parseInt(br.readLine());

		A = new int[C][R];

		findSitNum();

	}

	private static void findSitNum() {
		int x = 0, y = 0;
		int pointer = 0;
		int num = 1;

		while (num <= C * R) {
			if (num == sitNum) {
				System.out.println((x + 1) + " " + (y + 1));
				return;
			}

			int nowX = x + dx[pointer];
			int nowY = y + dy[pointer];

			if (nowX >= C || nowY >= R || nowX < 0 || nowY < 0 || A[nowX][nowY] != 0) {
				pointer = (pointer + 1) % 4;
				nowX = x + dx[pointer];
				nowY = y + dy[pointer];
			}

			A[x][y] = num++;
			x = nowX;
			y = nowY;
		}

		System.out.println(0);
	}


}