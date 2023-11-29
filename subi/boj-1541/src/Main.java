import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] strArr = str.split("-");

		int answer = 0;
		for (String s : strArr) {
			if (s == strArr[0]) {
				answer += findSum(s);
			} else {
				answer -= findSum(s);
			}
		}
		System.out.println(answer);
	}

	private static int findSum(String s) {
		String[] num = s.split("\\+");
		int sum = 0;
		for (String n : num) {
			sum += Integer.parseInt(n);
		}
		return sum;
	}

}