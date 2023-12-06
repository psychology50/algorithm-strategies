import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	static int sum[];
	static int start = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		arr = new int[n];
		sum = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		//초기세팅
		for (int i = 0; i < x; i++) {
			sum[0] += arr[i];
		}

		//슬라이딩
		for (int i = x; i < n; i++) {
			int j = i - x;
			add(arr[i]);
			remove(arr[j]);
		}

		int max = Arrays.stream(sum).max().getAsInt();
		if (max == 0) {
			System.out.println("SAD");
			return;
		} else {
			System.out.println(max);
		}

		int cnt = 0;

		for (int i = 0; i < sum.length; i++) {
			if (max == sum[i]) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	private static void add(int i) {
		start++;
		sum[start] = sum[start - 1] + i; //start = 3;
	}

	private static void remove(int j) {
		sum[start] -= j;
	}

}