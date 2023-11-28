import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		//두 개의 값이 들어갈 수 있다.
		ArrayList<int[]> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int metalW = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			arr.add(new int[] {metalW, P});
		}

		//2번째 요소를 기준으로 내림차순
		Collections.sort(arr, Comparator.comparingInt((int[] a) -> a[1]).reversed());

		int result = 0;
		int sum = 0;
		int count = 0;

		for (int[] array : arr) {
			//array[0] = 금속 무게, array[1] = 금속 가치
			while (sum <= W) {
				sum += array[0];
				result += array[0] * array[1];
				count++;
				if (sum < W) {
					int value = arr.get(count)[1];
					int left = W - sum;
					result = left * value;
				}
			}
		}

		System.out.println(result);

	}
}
