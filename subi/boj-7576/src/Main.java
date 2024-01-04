import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int m, n;
	static int[][] A;
	static boolean[][] visited;
	//우하좌상
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		A = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 1) {
					queue.add(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}


		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nowX = now[0] + dx[k];
				int nowY = now[1] + dy[k];
				if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
					if (!visited[nowX][nowY] && A[nowX][nowY] != -1) {
						visited[nowX][nowY] = true;
						A[nowX][nowY] = A[now[0]][now[1]] + 1;
						queue.add(new int[] {nowX, nowY});
					}
				}
			}
		}

		int Max = 0;

		if (!checkZero()) {
			System.out.println(-1);
			return;
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (A[i][j] > Max) {
						Max = A[i][j];
					}
				}
			}
			System.out.println(Max - 1);
		}

	}

	private static boolean checkZero() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}