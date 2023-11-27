import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean visited[][];
	//아래쪽 오른쪽 위쪽 왼쪽
	static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(s.substring(j, j + 1));
			}
		}

		//시작점 입력 (0,0)
		bfs(0, 0);

		//입력값은 1부터 시작이므로
		System.out.println(arr[n - 1][m - 1]);
	}

	private static void bfs(int i, int j) {
		//데이터가 2개 들어오니까 int 배열로
		Queue<int[]> queue = new LinkedList<>();

		//큐에 데이터 삽입
		queue.offer(new int[] {i, j});

		while (!queue.isEmpty()) { //queue가 안 비었을 때 까지
			int now[] = queue.poll(); //하나 꺼냄
			visited[i][j] = true; //방문했으니까 그 노드를 true로
			for (int k = 0; k < 4; k++) { //아래 오른쪽 위쪽 왼쪽 탐색
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if (x >= 0 && y >= 0 && x < n && y < m) { //배열 범위 안에서
					if (arr[x][y] != 0 && !visited[x][y]) {//0이 아니고 방문을 안한 노드일 때
						visited[x][y] = true;
						arr[x][y] = arr[now[0]][now[1]] + 1; //1 증가시킨 depth값 삽입!
						queue.add(new int[] {x, y}); //다음 값 넣어줌
					}
				}
			}

		}

	}
}