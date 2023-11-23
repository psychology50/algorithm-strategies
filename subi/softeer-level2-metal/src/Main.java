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

		List<AbstractMap.SimpleEntry<Integer, Integer>> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int metalW = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			list.add(new AbstractMap.SimpleEntry<>(P, metalW));

			list.sort(Map.Entry.<Integer, Integer>comparingByKey().reversed());

			int result = 0;
			while (W >= 0) {
				for (AbstractMap.SimpleEntry<Integer, Integer> entry : list) {
					if (W <= entry.getKey()) {
						result = W * entry.getValue();
					} else {
						int num = entry.getKey() * entry.getValue();
						W -= num;
					}
				}
			}

			System.out.println(result);


		}

	}

}
