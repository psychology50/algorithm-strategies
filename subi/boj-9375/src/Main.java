import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test = Integer.parseInt(br.readLine());

		for (int t = 0; t < test; t++) {
			HashMap<String, Integer> h = new HashMap(); //여기서 초기화 시켜줘야!!
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String types = st.nextToken();
				if (h.containsKey(types)) {
					h.put(types, h.get(types) + 1);
				} else {
					h.put(types, 1);
				}
			}

			int result = 1;
			for (int val : h.values()) { //안입는 경우 포함
				result *= (val + 1);
			}

			System.out.println(result - 1);
		}

	}

}