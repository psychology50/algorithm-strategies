import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			System.out.println(findNumber(num));
		}

	}

	static private int findNumber(int num) {

		boolean find = false;
		int result;
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) { //탐색할 부분이 없을 때까지 탐색
			int middle = (start + end) / 2;
			int middleValue = arr[middle];
			if (middleValue > num) {
				end = middle - 1;
			} else if (middleValue < num) {
				start = middle + 1;
			} else {
				find = true;
				break;
			}
		}

		if (find) {
			result = 1;
		} else {
			result = 0;
		}

		return result;
	}
}