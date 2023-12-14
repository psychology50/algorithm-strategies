import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int arr[];
	static boolean visited[];
	static int num = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			if (num == 0) return;
			arr = new int[num];
			visited = new boolean[num];
			for (int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			findLotto(0, 0);
		}
	}

	private static void findLotto(int depth, int start) {

		//6개만 출력하기 위함
		if (depth == 6) {
			for (int i = 0; i < num; i++) {
				if (visited[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}


		for (int i = start; i < num; i++) {
			visited[i] = true;
			findLotto(depth + 1, start + 1);
			visited[i] = false;
		}

	}
}