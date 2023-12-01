import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean visited[];
	//static boolean check[];
	static int check[];

	//중간에서 이블 그래프가 아니면, 탐색을 종료해야하므로 이분 그래프 유무도 필요!
	static boolean isBiGraph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		for (int t = 0; t < testCase; t++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); //정점,노드 수
			int e = Integer.parseInt(st.nextToken()); //간선 수
			isBiGraph = true; //이분그래프라고 가정하고 실행한다.

			//각 배열의 사이즈는 노드 수 + 1 만큼
			arr = new ArrayList[v + 1];
			visited = new boolean[v + 1];
			check = new int[v + 1];

			//모든 노드 탐색 => 1부터 v 또는 e 까지인 것을 명심하자!

			//각 정점 수, 노드 수에 대해서 리스트 초기화
			for (int i = 1; i <= v; i++) {
				arr[i] = new ArrayList<>();
			}

			//간선 수 만큼
			for (int i = 1; i <= e; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				arr[start].add(end);
				arr[end].add(start); //양방향이므로
			}

			//정점 수 만큼, 모든 노드에 대해 => if(!visted[i]) 가 없어야 한다.
			for (int i = 1; i <= v; i++) {
				if (isBiGraph) { //이분 그래프이면 계속 탐색한다.
					dfs(i); //시작점 대입
				} else { // 중간에서 이분 그래프가 아님이 판명된다면 멈춘다.
					break;
				}
			}

			if (isBiGraph) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}

	private static void dfs(int node) {

		//방문한 노드이면 이분 그래프임을 check 배열읇 보고 판별해줘야 함 -> 이 과정을 모든 노드에 대해서 해야하므로 안의 if 문에서 else로 써줘야 한다.
//		if (visited[node]) {
//			//3번부터 비교 가능, 3번이면 1번이랑 비교, 4번이면 2번이랑 비교, 5번이면 3,1번이랑 비교
//			//(3-2), (4-2), (5-2, 5-4)
//			for (int i = 2; i <= node; i += 2) {
//				if (check[node] == check[node - i]) {
//					isBiGraph = !isBiGraph; -> false로 바꿔줘야 한다.
//				}
//			}
//		}

		visited[node] = true;

		//현재 노드의 연결 된 노드 중
		for (int i : arr[node]) { //현재 노드에서 인접한 노드들을 다 살펴보면서
			if (!visited[i]) { //방문하지 않은 노드일 때
				//0과 1로 판별
				check[i] = (check[node] + 1) % 2;
				dfs(i);
			} else { //방문한 노드일 때 (이 코드 else if 로 한 줄에 표현할 수 있음)
				if (check[node] == check[i]) { //현재 나의 노드와 이미 방문한 노드가 같으면 (4 -> 2)
					isBiGraph = false;
				}
			}
		}


	}
}