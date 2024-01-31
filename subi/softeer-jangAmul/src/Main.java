import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] block;
	static List<Integer> list = new ArrayList<>();
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];
		block = new int[N * N];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s.substring(j, j + 1));
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					count++;
					bfs(i, j);
				}
			}
		}

		System.out.println(count);

		for (int n : block) {
			if (n != 0) {
				list.add(n);
			}
		}

		Collections.sort(list);

		for (int n : list) {
			System.out.println(n);
		}

	}

	private static void bfs(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] {x, y});
		visited[x][y] = true;
		block[count]++;

		while (!Q.isEmpty()) {
			int now[] = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nowX = now[0] + dx[k];
				int nowY = now[1] + dy[k];
				if (nowX >= 0 && nowY >= 0 && nowX < N && nowY < N) {
					if (!visited[nowX][nowY] && map[nowX][nowY] != 0) {
						Q.add(new int[] {nowX, nowY});
						visited[nowX][nowY] = true;
						block[count]++;
					}
				}
			}
		}


	}

}
