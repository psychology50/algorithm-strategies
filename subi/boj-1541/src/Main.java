import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split("-");

		int result = 0;

		for (int i = 0; i < s.length; i++) {
			if (i == 0) {
				result = findSum(s[i]);
			} else {
				result -= findSum(s[i]);
			}
		}
		System.out.println(result);
	}

	private static int findSum(String s) {

		int sum = 0;
		String ss[] = s.split("\\+");
		for (int i = 0; i < ss.length; i++) {
			sum += Integer.parseInt(ss[i]);
		}
		return sum;
	}


}