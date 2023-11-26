import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int arr[] = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
			arr[i] = Integer.parseInt(s.substring(i, i + 1));
		}

		//최대갑을 값이 아닌 인덱스 번호로 사용한다.
		for (int i = 0; i < arr.length; i++) {
			int max = i; //첫 번째 인덱스를 max값으로
			//i 번째 다음 구간부터
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[max]) {
					max = j;
				}
			}
			if (arr[i] < arr[max]) {
				int temp = arr[i];
				arr[i] = arr[max];
				arr[max] = temp;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}