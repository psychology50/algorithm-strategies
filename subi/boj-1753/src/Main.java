import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int endPoint;
	int w;

	public Node(int endPoint, int w) {
		this.endPoint = endPoint;
		this.w = w;
	}

	//현재 객체(this)의 가중치(w)와 비교 대상 객체(e)의 가중치를 비교
	//현재 객체가 더 크면 1, 작으면 -1을 반환
	public int compareTo(Node e) {
		if (this.w > e.w) return 1;
		else return -1;
	}

}


public class Main {
	public static PriorityQueue<Node> queue = new PriorityQueue<>();
	static ArrayList<Node>[] A;
	static int[] P;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		A = new ArrayList[v + 1];
		P = new int[v + 1];
		visited = new boolean[v + 1];

		for (int i = 0; i <= v; i++) {
			A[i] = new ArrayList<>();
			P[i] = Integer.MAX_VALUE;
		}

		int s = Integer.parseInt(br.readLine());
		P[s] = 0; //시작 노드 배열은 0으로 초기화!
		queue.add(new Node(s, 0));

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int sNode = Integer.parseInt(st.nextToken());
			int eNode = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			A[sNode].add(new Node(eNode, weight));
		}
		while (!queue.isEmpty()) {
			Node current = queue.poll();
			int cPoint = current.endPoint;
			if (visited[cPoint]) continue; //이미 방문한 적이 있는 노드는 다시 큐에 넣지 않음
			visited[cPoint] = true;
			for (int i = 0; i < A[cPoint].size(); i++) {
				Node tmp = A[cPoint].get(i);
				int next = tmp.endPoint;
				int nValue = tmp.w;
				if (P[next] > P[cPoint] + nValue) {
					P[next] = nValue + P[cPoint];
					queue.add(new Node(next, P[next]));
				}
			}
		}

		for (int i = 1; i <= v; i++) {
			if (visited[i]) System.out.println(P[i]);
			else System.out.println("INF");
		}
	}
}