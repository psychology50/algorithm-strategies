import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int toy[];
	static ArrayList<Integer> window = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		toy = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			toy[i] = Integer.parseInt(st.nextToken());
			if (toy[i] == 1) {
				window.add(i);
			}
		}

		if (window.size() < k) { //라이언 인형의 개수가 k보다 적은 경우 -1호출 후 종료
			System.out.println(-1);
			return;
		}

		int min = Integer.MAX_VALUE;
		int start = 0, end = k - 1;
		// 부분 배열의 시작 위치를 탐색
		while (true) {
			if (end == window.size()) break;
			int cnt = window.get(end) - window.get(start) + 1;
			min = Math.min(min, cnt);

			start++;
			end++;
		}


		System.out.println(min);


		//k개 이상부터 부분 문자열로 슬라이딩이 가능하고
		//시작부터 마지막까지 탐색했을 때 1이 k개 이상이 없으면 탐색을 종료시켜도 된다.
		//시작부터 1을 k개를 만나면 그게 바로 최소 구간이니까 멈추고 시작을 한 칸 앞으로 보내준다.
		//구간을 모두 탐색해서 나온 최솟값 중에 가장 최솟값을 찾으면 되는데, 이거를 배열에 넣고 배열을 탐색해서 가장 min값을 찾는 방법말고
		//min 값을 두고 탐색할 때마다 이전 값과 비교해서 현재 탐색 값이 min보다 작으면 min을 그 값으로 업데이트시키자.
		//k는 2이상일 때부터이다.
		// 0이상 k미만 탐색, 0이상 k일때 탐색.....0이상 배열의 길이미만까지 탐색 - 1차 탐색
		// 1이상 k+1미만 탐색, 1이상 k+1일때 탐색.....1이상 배열의 길이미만까지 탐색 - 1차 탐색
		// 이 탐색을 언제까지? -> n-k 미만까지 (10-3) 미만까지

		//위에 보다 더 간단한 방법이 있었다.
		//1의 인덱스를 추출해서 슬라이싱하면 됌!


	}
}