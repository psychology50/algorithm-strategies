import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if (beforePermutation()) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		} else {
			System.out.println(-1);
		}
	}

	private static boolean beforePermutation() {
		int i = arr.length - 1;

		while (i > 0 && arr[i] > arr[i - 1]) { //앞 배열이 더 클 때까지 --
			i--;
		}

		while (i == 0) {
			return false;
		}

		//내려갔는데 더 이전보다 큰 숫자가 나타나면
		int j = arr.length - 1;
		while (arr[i - 1] < arr[j]) { //arr[j]가 arr[i]보다 작을 때까지 뺸다.
			j--;
		}

		int temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;

		int k = arr.length - 1;
		while (i < k) { //바꾸고 난 다음에는 순열을 내림차순으로
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
			i++;
			k--;
		}

		return true;

	}
}