import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean visited[];
	static boolean arrive;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());


		A = new ArrayList[node];
		visited = new boolean[node];

		for (int i = 0; i < node; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int sNode = Integer.parseInt(st.nextToken());
			int eNode = Integer.parseInt(st.nextToken());
			A[sNode].add(eNode);
			A[eNode].add(sNode);
		}

		for (int i = 0; i < node; i++) {
			dfs(i, 1);
			if (arrive) break; //이거 안 해주면 0에서 탐색했을 때 depth가 5여도 1,2,3, 모두를 탐색한다.
			//노드 0 일 때 5가 아니면 1,2,3... 모두를 탐색해야 하는 것이지 depth가 5라면 탐색을 노드 0에서 끝낸다.
		}
		if (arrive) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}


	// 재귀
	private static void dfs(int node, int depth) { //이 코드에서 노드 0으로 시작했을 때
		// depth=5일 때 바로 끝나지 않고 다시 거슬러 올라가면서 다 탐색해서 false 해주고 끝난다.
		visited[node] = true;
		if (depth == 5) {
			arrive = true;
			return; //for문의 dfs 코드로 가는데, 만약에 위에 for문에서  if (arrive) break; 가 없으면 안 빠져 나가고 1,2,3..의 for문이 계속 실행된다.
		}
		for (int i : A[node]) {
			if (!visited[i]) {
				dfs(i, depth + 1);
			}
		}
		visited[node] = false; //depth에서 하나씩 빠져나오면서 실행하는거
	}
}