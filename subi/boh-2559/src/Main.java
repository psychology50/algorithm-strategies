import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int arr[];
	static int sArr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new int[n];
		sArr = new int[n - k + 1]; // 합 배열

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		//계속 start, end를 증가시키는데 end가 배열의 범위를 벗어나기 전까지 실행시켜야 함.
		//안 벗어나면, start부터 end까지의 sum을 구하고 sArr배열에 저장한다.


		int start = 0;
		int end = 0;

		//while안의 동작은 while의 밖의 start에 영향을 주지 않는다.
		while (end < arr.length) {
			int sum = 0;
			end = start + k;
			for (int i = start; i < end; i++) { //처음에 0과 0이 들어오니까 앞에서 증가시켜줘야
				sum += arr[i];
			}
			sArr[start] = sum;
			start++;
		}

		int max = Arrays.stream(sArr).max().getAsInt();
		System.out.println(max);


	}
}