import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] x = {1, 0, -1, 0}, y = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 0; t < test; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());


			//가로의 길이 M 세로의 길이 N
			int[][] map = new int[M][N];
			boolean[][] visited = new boolean[M][N];
			int[] num = new int[N * M];
			Queue<int[]> queue = new LinkedList<>();
			int cnt = 0;
			int result = 0;

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						cnt++;
						queue.add(new int[] {i, j});
						visited[i][j] = true;
						num[cnt]++;
						while (!queue.isEmpty()) {
							int now[] = queue.poll();
							for (int w = 0; w < 4; w++) {
								int nowX = now[0] + x[w];
								int nowY = now[1] + y[w];
								if (nowX >= 0 && nowY >= 0 && nowX < M && nowY < N) {
									if (!visited[nowX][nowY] && map[nowX][nowY] == 1) {
										visited[nowX][nowY] = true;
										num[cnt]++;
										queue.add(new int[] {nowX, nowY});
									}
								}
							}
						}
					}
				}
			}

			for (int n : num) {
				if (n != 0) {
					result++;
				}
			}

			System.out.println(result);

		}
	}


}