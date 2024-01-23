import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken());
		int term = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> A = new ArrayList<>();
		for (int i = 0; i < term; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		Set<Integer> set = new HashSet<>();
		int num = 0;
		int[] seq = new int[size];
		int cnt = 0;

		for (int i = 0; i < term; i++) {
			num = A.get(i);
			if (set.contains(num)) continue;
			if (set.size() < size) {
				set.add(num);
				continue;
			}
			int max = -1, idx = -1;
			for (int s : set) {
				List<Integer> subA = A.subList(i + 1, term);

				int temp;
				if (subA.contains(s)) {
					temp = subA.indexOf(s) + 1;
				} else {
					temp = term - i - 1;
				}
				if (temp > max) {
					max = temp;
					idx = s;
				}
			}

			set.remove(idx);
			set.add(num);
			cnt++;

		}

		System.out.println(cnt);


	}
}