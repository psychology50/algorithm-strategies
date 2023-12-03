import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i][0] = start;
			arr[i][1] = end;
		}

		//1번째 인덱스를 기준으로 오름차순
		//Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[1]));
		Arrays.sort(arr, (o1, o2) -> {
			if (o1[1] == o2[1])
				return o1[0] - o2[0];

			return o1[1] - o2[1];
		});

		int cnt = 0;
		int end = 0;

		for (int i = 0; i < arr.length; i++) {
			if (end <= arr[i][0]) {
				cnt++;
				end = arr[i][1];
			}
		}
		System.out.println(cnt);


	}
}