import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> map = new HashMap<>();


		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int metalW = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			map.put(metalW, P);
		}

		//키를 기준으로 Map 정렬
		List<Integer> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);

		int result = 0;

		for (int i = map.size() - 1; i >= 0; i--) {
			if (map.get(i).intValue() < W) {
				result += map.get(i) * map.get(i).intValue();
				W -= map.get(i).intValue();
			} else {
				result = 100 * map.get(i).intValue();
			}
		}

		System.out.println(result);


	}
}
