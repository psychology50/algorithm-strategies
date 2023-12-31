import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static int[] answer;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new ArrayList[N + 1];
		answer = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1]; //방문 배열 bfs탐방마다 초기화!!!
			bfs(i);
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, answer[i]);
		}

		for (int i = 1; i <= N; i++) {
			if (max == answer[i]) {
				bw.write(i + " ");
			}
		}

		br.close();
		bw.flush();
		bw.close();

	}

	private static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int n : A[now]) {
				if (!visited[n]) {
					visited[n] = true;
					answer[n]++;
					queue.add(n);
				}
			}
		}
	}

}