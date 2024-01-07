import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int target;
	int value;

	public Node(int target, int value) {
		this.target = target;
		this.value = value;
	}

	public int compareTo(Node w) {
		return value - w.value;
	}

}

public class Main {

	static ArrayList<Node>[] A;
	static int[] distance;
	static boolean[] visited;
	static PriorityQueue<Node> Q = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		A = new ArrayList[V + 1];
		distance = new int[V + 1];
		visited = new boolean[V + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;//첫 시작점의 거리 배열은 0으로 채우자.

		for (int i = 1; i <= V; i++) { //사용 안 하는 0은 굳이 초기화 해줄 필요가 없다
			A[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			A[s].add(new Node(e, w));
		}

		//최초 시작점과 거리 = 0 삽입
		Q.add(new Node(K, 0));
//		visited[K] = true; 아래에서 queue를 꺼낼 때 방문 처리 해주므로 필요없다!

		while (!Q.isEmpty()) {
			Node now = Q.poll(); //poll을 받을 때는 Node 클래스로 받아야 한다.
			int nowT = now.target; //target만 필요!
			if (!visited[nowT]) { //1.현재 노드 검사
				visited[nowT] = true;
				for (Node n : A[nowT]) { // 2가 들어온거야! 2에 대해 (3,4)와 (4,5)가 존재함!
					//현재 들어있는 거리 배열(3)보다 새로 계산한 거리 배열 (거리배열 2에 있는 2 + 3의 가중치 4 = 6) 이 더 작다면 바꿈
					if (!visited[n.target] && distance[n.target] > distance[nowT] + n.value) { //2.타겟노드까지 검사
//						visited[n.target] = true;
						distance[n.target] = distance[nowT] + n.value;
						Q.add(new Node(n.target, distance[n.target])); //queue에 넣어줄 때는 타켓이랑, 계산한 타겟의 거리 배열 값을 넣어준다.
						//최소 거리가 게속 갱신되겠지!
					}
				}
			}
		}

		//방문 경로가 없을 경우는 visited로 방문 여부를 검사해주면 쉽게 출력할 수 있다!
		for (int i = 1; i <= V; i++) {
			if (visited[i]) {
				System.out.println(distance[i]);
			} else {
				System.out.println("INF");
			}
		}

	}
}