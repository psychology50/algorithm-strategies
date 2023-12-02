import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int qNum = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < qNum; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());

			//바로 연결하지 않고 대표노드를 찾아서 연결
			if (q == 0) {
				union(nodeA, nodeB);
			} else if (q == 1) {
				if (find(nodeA) == find(nodeB)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}

		}

	}

	private static void union(int nodeA, int nodeB) {
		//find 연산을 받는다.
		nodeA = find(nodeA);
		nodeB = find(nodeB);

		if (nodeA != nodeB) {
			if (nodeA < nodeB) arr[nodeB] = nodeA;
			else {
				arr[nodeA] = nodeB;
			}
		}

	}

	private static int find(int node) {
		if (arr[node] == node) { //대표 노드면 그 값 return
			return node;
		} else { //데표 노드가 아니면
			//return find(arr[node]); 이렇게만 하면 값을 저장하진 않는다.
			return arr[node] = find(arr[node]); //이렇게 안하면 시간초과 발생
		}
	}
}