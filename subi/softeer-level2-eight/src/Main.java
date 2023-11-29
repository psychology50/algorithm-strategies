import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int arr[] = new int[8];
		int ascedAdd[] = new int[8];
		int descdAdd[] = new int[8];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			descdAdd[i] = arr[i];
			ascedAdd[i] = arr[i];
		}

		//오름차순
		Arrays.sort(ascedAdd);
		//내림차순
		Integer[] arr3 = Arrays.stream(descdAdd).boxed().toArray(Integer[]::new);
		Arrays.sort(arr3, Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == descdAdd[i]) {
				System.out.println("descending");
			}
			if (arr[i] != ascedAdd[i]) {
				System.out.println("ascending");
			}
		}

	}
}