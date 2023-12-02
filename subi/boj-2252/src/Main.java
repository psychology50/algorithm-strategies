import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int inDegree[];
	static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		inDegree = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			nodeList.add(new ArrayList<>());
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			nodeList.get(start).add(end);
			inDegree[end]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		//진입 차수 조사
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		//큐가 빌 때 까지 -> 큐에 들어가 있는 게 있으면 동작한다.
		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.println(now + " ");
			for (int next : nodeList.get(now)) {
				inDegree[next]--;
				if (inDegree[next] == 0) {
					queue.offer(next);
				}
			}
		}


	}
}