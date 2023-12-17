import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
	int endPoint;
	int weight;

	public Node(int endPoint, int weight) {
		this.endPoint = endPoint;
		this.weight = weight;
	}

}

public class Main {
	static ArrayList<Node>[] A;
	static boolean visited[];
	static int wLength[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine());

		A = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		wLength = new int[V + 1];

		for (int i = 0; i < V + 1; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int startNode = Integer.parseInt(st.nextToken());
			while (true) {
				int end = Integer.parseInt(st.nextToken());
				if (end == -1) break;
				int w = Integer.parseInt(st.nextToken());
				A[startNode].add(new Node(end, w));
			}
		}

		bfs(2);

		//첫 번째 노드의 bfs가 끝날 시 최장 거리의 노드로 한 번 더 bfs 실행

		int MaxIndex = 1; //배열을 V+1까지 만듦!
		for (int i = 2; i <= V; i++) {
			if (wLength[MaxIndex] < wLength[i]) {
				MaxIndex = i;
			}
		}

		//초기화!!!!
		visited = new boolean[V + 1];
		wLength = new int[V + 1];
		bfs(MaxIndex);

		Arrays.sort(wLength);
		System.out.println(wLength[V]);

	}

	private static void bfs(int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startNode);
		visited[startNode] = true;

		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			for (Node i : A[nowNode]) {
				int end = i.endPoint;
				int w = i.weight;
				if (!visited[end]) {
					visited[end] = true;
					wLength[end] = wLength[nowNode] + w; //이전 값에서 값을 축적!
					queue.add(end);
				}
			}
		}

	}
}