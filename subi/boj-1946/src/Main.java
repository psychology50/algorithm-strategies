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

		ArrayList<int[]> arr;

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			arr = new ArrayList<>(); //
			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr.add(new int[] {a, b});
			}

			//오름차순 정렬
			Collections.sort(arr, Comparator.comparingInt((int[] a) -> a[0]));

			int cnt = n;

			for (int j = 1; j < arr.size(); j++) {
				if (arr.get(0)[1] < arr.get(j)[1]) {
					if (arr.get(arr.size() - 1)[1] > arr.get(0)[1]) {
						//나중에 -1 헤줄꺼기 때문에 맨 마지막의 2번째 원소값이 첫 번째 값보다 크면 1 증가시켜준다.
						cnt++;
					}
					cnt--;
				}
			}

			System.out.println(cnt - 1);

		}

	}
}