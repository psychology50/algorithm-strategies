import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int light[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		light = new int[n];

		for (int i = 0; i < b; i++) {
			int broken = Integer.parseInt(br.readLine());
			light[broken - 1] = 1; //고장난 부분을 1로
		}

		int start = 0;
		int end = k;
		int min = Integer.MAX_VALUE;
		int cnt = 0;

//		for (int i = start; i < end; i++) {
//			if (end == light.length) break;
//			if (light[i] == 1) {
//				cnt++; //수리해야 할 것
//			}
//			min = Math.min(min, cnt);
//			System.out.println(min);
//			start++;
//			end++;
//		}

		// 초기 구간에서 수리해야 하는 전구 개수 계산
		for (int i = 0; i < k; i++) {
			if (light[i] == 1) {
				cnt++; // 수리해야 할 것
			}
		}
		min = Math.min(min, cnt);

		// 나머지 구간에 대해 수리해야 하는 전구 개수 계산
		for (int i = k; i < n; i++) {
			int j = i - k;
			if (light[j] == 1) {
				cnt--;
			}
			if (light[i] == 1) {
				cnt++;
			}
			min = Math.min(min, cnt);
		}

		System.out.println(min);

	}
}