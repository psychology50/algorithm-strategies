import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Node>[] A;
	static boolean[] visited;
	static int[] distance;
	static PriorityQueue<Node> queue = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		A = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		distance = new int[N + 1];


		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sNode = Integer.parseInt(st.nextToken());
			int eNode = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			A[sNode].add(new Node(eNode, weight));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		distance[start] = 0;

		int result = dijkstra(start, end);
		System.out.println(result);
	}

	private static int dijkstra(int start, int end) {
		queue.offer(new Node(start, 0));
		while (!queue.isEmpty()) {
			Node nowNode = queue.poll();
			int now = nowNode.ePoint;
			if (visited[now]) continue;
			visited[now] = true;
			for (Node n : A[now]) {
				if (!visited[n.ePoint] && distance[n.ePoint] > distance[now] + n.w) {
					distance[n.ePoint] = distance[now] + n.w;
					queue.add(new Node(n.ePoint, distance[n.ePoint]));
				}
			}
		}
		return distance[end];
	}

}

class Node implements Comparable<Node> {
	int ePoint;
	int w;

	public Node(int ePoint, int w) {
		this.ePoint = ePoint;
		this.w = w;
	}

	@Override
	public int compareTo(Node e) {
		return w - e.w;
	}
}