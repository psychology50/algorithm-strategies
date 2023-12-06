import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char original[];
	static int check[];
	static int current[];
	static int cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		original = br.readLine().toCharArray();
		check = new int[4];
		current = new int[4];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			check[i] = Integer.parseInt(st.nextToken());
			if (check[i] == 0) //0이면 문자열이 없는 상태를 만족하므로 ++
				cnt++;
		}

		//초기 부분 문자열 지정
		for (int i = 0; i < p; i++) {
			addCurrent(original[i]);
		}

		int result = 0;
		//검사 여기서 한 번
		if (cnt == 4) {
			result++;
		}

		//나머지 문자열 슬라이딩 (핵심!)
		for (int i = p; i < s; i++) {
			int left = i - p;
			addCurrent(original[i]); //0,1,2
			removeCurrent(original[left]); //9,10,11

			//for문 안에서 확인
			if (cnt == 4) {
				result++;
			}
		}

		//검사 여기서 두 번
		System.out.println(result);

		br.close();
	}

	private static void addCurrent(char c) {
		switch (c) {
			case 'A':
				current[0]++;
				if (current[0] == check[0]) {
					cnt++;
				}
				break;
			case 'C':
				current[1]++;
				if (current[1] == check[1]) {
					cnt++;
				}
				break;
			case 'G':
				current[2]++;
				if (current[2] == check[2]) {
					cnt++;
				}
				break;
			case 'T':
				current[3]++;
				if (current[3] == check[3]) {
					cnt++;
				}
				break;
		}
	}

	private static void removeCurrent(char c) {
		switch (c) {
			case 'A':
				if (current[0] == check[0]) { //먼저 확인하고 --
					cnt--;
				}
				current[0]--; //그 다음 현재 상태 배열 --
				break;
			case 'C':
				if (current[1] == check[1]) {
					cnt--;
				}
				current[1]--;
				break;
			case 'G':
				if (current[2] == check[2]) {
					cnt--;
				}
				current[2]--;
				break;
			case 'T':
				if (current[3] == check[3]) {
					cnt--;
				}
				current[3]--;
				break;
		}
	}


}