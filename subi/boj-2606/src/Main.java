import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] node;
	static boolean[] visited;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int Com = Integer.parseInt(br.readLine());
		int Pair = Integer.parseInt(br.readLine());

		node = new ArrayList[Com + 1];
		visited = new boolean[Com + 1];

		for (int i = 1; i <= Com; i++) {
			node[i] = new ArrayList<>();
		}

		for (int i = 0; i < Pair; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			node[start].add(end);
			node[end].add(start);
		}

		bfs(1);
		System.out.println(cnt);
	}

	public static void bfs(int start) {
		visited[start] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int newNode = queue.poll();
			visited[newNode] = true;
			for (int n : node[newNode]) {
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
					cnt++;
				}
			}
		}
	}

}