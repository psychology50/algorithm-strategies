import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M, K, X;
	static ArrayList<Integer>[] A;
	static int[] visited;

	static List<Integer> answer = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		A = new ArrayList[N + 1];
		visited = new int[N + 1];
		visited[0] = -1;

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
			visited[i] = -1;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
		}

		bfs(X);

		for (int i = 1; i <= N; i++) {
			if (visited[i] == K) {
				answer.add(i);
			}
		}

		if (answer.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(answer);
			for (int n : answer) {
				System.out.println(n);
			}
		}

	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start]++; //처음 시작 노드 = 0
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int n : A[now]) {
				if (visited[n] != -1) {
					continue; //방문한 노드면 방문 안 함
				}
				visited[n] = visited[now] + 1;
				queue.add(n);
			}
		}


	}
}