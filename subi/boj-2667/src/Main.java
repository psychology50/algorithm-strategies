import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[][] A;
	static boolean[][] visited;
	static int[] count;
	static int danji = 0;
	static int n = 0;
	//우하좌상
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		A = new int[n][n];
		visited = new boolean[n][n];
		count = new int[n * n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				A[i][j] = Integer.parseInt(s.substring(j, j + 1));
			}
		}


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && A[i][j] == 1) {
					danji++;
					bfs(i, j);
				}
			}
		}

		Arrays.sort(count);

		System.out.println(danji);

		for (int n : count) {
			if (n != 0) {
				System.out.println(n);
			}
		}

	}

	private static void bfs(int x, int y) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		count[danji]++;

		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nowX = now[0] + dx[k];
				int nowY = now[1] + dy[k];
				if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < n) {
					if (!visited[nowX][nowY] && A[nowX][nowY] == 1) {
						visited[nowX][nowY] = true;
						count[danji]++;
						queue.add(new int[] {nowX, nowY});
					}
				}
			}
		}

	}
}