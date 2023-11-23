import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int arr[] = new int[input];
		for (int i = 0; i < input; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < input - 1; i++) {
			for (int j = 0; j < input - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[i + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < input; i++) {
			System.out.println(arr[i]);
		}

	}
}