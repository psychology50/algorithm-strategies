import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a.add(Integer.parseInt(st1.nextToken()));
			b.add(Integer.parseInt(st2.nextToken()));
		}

		int result = 0;

		for (int i = 0; i < n; i++) {
			int max = 0;
			int min = 1000;

			// 오류: max와 min은 반복문 내에서 초기화되어야 함
			for (int j = 0; j < a.size(); j++) {
				if (a.get(j) >= max) {
					max = a.get(j);
				}
			}

			for (int j = 0; j < b.size(); j++) {
				if (b.get(j) <= min) {
					min = b.get(j);
				}
			}

			result += (max * min);

			// 오류: max와 min을 제거할 때 반드시 현재 리스트에서 찾아서 제거해야 함
			a.remove(Integer.valueOf(max));
			b.remove(Integer.valueOf(min));
		}

		System.out.println(result);
	}
}
