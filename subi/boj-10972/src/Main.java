import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

		if (nextPermutation()) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		} else {
			System.out.println(-1);
		}
	}

	private static boolean nextPermutation() {

		int i = arr.length - 1;

		while (i > 0 && arr[i - 1] > arr[i]) {
			i--; //1342면 i가 3일 때까지 --
		}

		if (i == 0) return false; //모두 내림차순이면 false


		int j = arr.length - 1; //맨오른쪽

		while (arr[j] < arr[i - 1]) { //맨 오른쪽부터 왼쪽으로 오면서 3보다 큰 숫자가 없으면 계속 왼쪽으로 이동한다.
			// 처음 접하는 3보다 큰 숫자가 오면 그게 내림차순 수열에서 가장 작은 수이다.
			j--; //
		}

		//2보다 큰 숫자가 j번째 -> swap 연산
		int temp = arr[i - 1];
		arr[i - 1] = arr[j]; //3을 4와 swap
		arr[j] = temp;

		//32를 오름차순 정렬
		int k = arr.length - 1;
		while (i < k) { // swap한 배열의 +1 번 인덱스 (i) 부터 끝까지 가면서
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
			i++; //이러면 for문이랑 똑같은 코드!
			k--;
		}
		return true;
	}

}