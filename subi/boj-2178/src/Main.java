import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[][];
	static int arr[][];
	static int N = 0, M = 0;

	//오하왼상
	static int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(s.substring(j, j + 1)); //문자열 나누기에 주의!
			}
		}
		dfs(0, 0);
		System.out.println(arr[N - 1][M - 1]);
	}

	private static void dfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
					if (!visited[nextX][nextY] && arr[nextX][nextY] != 0) {
						visited[nextX][nextY] = true;
						arr[nextX][nextY] = arr[now[0]][now[1]] + 1;
						queue.add(new int[] {nextX, nextY});
					}
				}
			}
		}
	}
}