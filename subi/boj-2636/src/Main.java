import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N = 0, M = 0;
	static int[][] cheese;
	static boolean[][] visited;

	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cheese = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bfs(i, j);
			}
		}

	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});

		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			visited[now[0]][now[1]] = true;
			for (int k = 0; k < 4; k++) {
				int nowX = now[0] + k;
				int nowY = now[1] + k;
				if (nowX >= 0 && nowY >= 0 && nowX < M && nowY < N && cheese[nowX][nowY] == 1) {
					if (!visited[nowX][nowY]) {
						queue.add(new int[] {nowX, nowY});

					}
				}
			}
		}

	}

}