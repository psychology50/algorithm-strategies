import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt = 0;

			A = new ArrayList[N + 1];
			visited = new boolean[N + 1];

			for (int i = 0; i <= N; i++) {
				A[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				A[start].add(end);
				A[end].add(start);
			}

			Queue<Integer> queue = new LinkedList<>();
			queue.add(1);
			visited[1] = true;

			for (boolean n : visited) {
				if (!n) {
					while (!queue.isEmpty()) {
						int now = queue.poll();
						if (!visited[now]) {
							queue.add(now);
							visited[now] = true;
						}
					}
					cnt++;
				}
			}

			System.out.println(cnt - 1);

		}

	}
}