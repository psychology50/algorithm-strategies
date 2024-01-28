import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> list = new ArrayList<>();
	static ArrayList<Node>[] ANode;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		list.add(0, -1);
		list.add(1, 1);
		list.add(2, 2);
		ANode = new ArrayList[10001];

		for (int i = 0; i < 10001; i++) {
			ANode[i] = new ArrayList<>();
		}

		int cnt = 1;

		for (int i = 2; i < list.size(); i++) {
			int newValue = list.get(i - 1) + cnt;
			if (newValue > 10000) {
				break;
			}
			list.add(i, newValue);
			cnt++;
		}

		int inCnt = 0;
		for (int i = 1; i < 10000; i++) {
			if (list.contains(i)) inCnt++;
			int endNum = i + inCnt;
			if (endNum + 1 < 10000) {
				ANode[i].add(new Node(endNum, 1));
				ANode[i].add(new Node(endNum + 1, 1));
				ANode[endNum].add(new Node(i, 1));
				ANode[endNum + 1].add(new Node(i, 1));
			}
		}


		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			int[] distance = new int[10001];
			Arrays.fill(distance, Integer.MAX_VALUE);
			boolean[] visited = new boolean[10001];
			PriorityQueue<Node> queue = new PriorityQueue<>();
			distance[start] = 0;

			queue.offer(new Node(start, 0));
			distance[start] = 0;
			while (!queue.isEmpty()) {
				Node nowNode = queue.poll();
				int now = nowNode.ePoint;
				if (visited[now]) continue;
				visited[now] = true;
				for (Node n : ANode[now]) {
					if (!visited[n.ePoint] && distance[n.ePoint] > distance[now] + 1) {
						distance[n.ePoint] = distance[now] + 1;
						queue.add(new Node(n.ePoint, distance[n.ePoint]));
					}
				}
			}
			int result = distance[end];
			System.out.println("#" + test_case + " " + result);
		}

	}

}

class Node implements Comparable<Node> {
	int ePoint;
	int value;

	public Node(int ePoint, int value) {
		this.ePoint = ePoint;
		this.value = value;
	}

	public int compareTo(Node w) {
		return value - w.value;
	}

}