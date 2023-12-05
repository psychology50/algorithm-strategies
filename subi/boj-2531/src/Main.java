import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int num[];
	static int dArr[];
	static int cnt[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		num = new int[n + k - 1];
		dArr = new int[d];
		cnt = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < k - 1; i++) {
			num[n + i] = num[i];
		}

		int start = 0;
		int end = 0;
		int j = 0;


		while (end < num.length) {
			dArr = new int[d]; //초기화를 여기서 해줘야!
			dArr[c - 1] = 1;//쿠폰 번호를 dArr배열에 +1 //30이면 29번째에 +1
			end = start + k;
			//num배열을 슬라이딩 하면서 나온 값을 aArr[i][결과값] 1;
			for (int i = start; i < end; i++) {
				int result = num[i];
				dArr[result - 1]++; //0열 부터니까 num[i]-1이다.
			}
			for (int i = 0; i < d; i++) {
				if (dArr[i] != 0) {
					cnt[j]++;
				}
			}
			start++;
			j++;
		}
		System.out.println(Arrays.stream(cnt).max().getAsInt());

	}
}