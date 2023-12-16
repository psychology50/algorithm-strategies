import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		arr = new ArrayList[node + 1];
		visited = new boolean[node + 1];

		for (int i = 1; i <= node; i++) { //각 노드별로 초기화
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int sNode = Integer.parseInt(st.nextToken());
			int eNode = Integer.parseInt(st.nextToken());
			arr[sNode].add(eNode);
			arr[eNode].add(sNode);
		}

		for (int i = 1; i <= node; i++) {
			Collections.sort(arr[i]);
		}
		dfs(start);
		System.out.println();

		//방문 배열 초기화!
		visited = new boolean[node + 1];
		bfs(start);
	}

	private static void dfs(int node) {
		System.out.print(node + " ");

		visited[node] = true;
		for (int i : arr[node]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;

		while (!queue.isEmpty()) {
			int newNode = queue.poll();//꺼내고
			System.out.print(newNode + " ");
			for (int i : arr[newNode]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}

	}
}