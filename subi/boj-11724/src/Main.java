import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[];
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1]; //0번 사용 안함
		arr = new ArrayList[n + 1];

		//각 리스트에 대해 인접 리스트를 만들어준다.
		for (int i = 1; i < n + 1; i++) {
			arr[i] = new ArrayList<>();
		}

		//인접 리스트에 값을 대입한다.
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			//4 -> 5, 5 -> 4 (양방향 가능)
			arr[start].add(end);
			arr[end].add(start);
		}

		int count = 0; //dfs 갯수 즉, 답을 세는 변수

		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) { // 방문하지 않은 노드이먄
				count++;
				dfs(i);
			}
		}

		System.out.println(count);

	}

	private static void dfs(int v) {
		if (visited[v]) {
			return;
		} //현재 노드가 방문한 노드이면

		//현재 노드가 방문 노드가 아니면 방문할꺼니까 true로 설정
		visited[v] = true;
		for (int i : arr[v]) { //현재 노드에서 인접한 노드들을 다 살펴보면서
			if (!visited[i]) { //방문하지 않은 노드가 있다면
				dfs(i); //dfs를 다시 실행
			}
		}

	}


}