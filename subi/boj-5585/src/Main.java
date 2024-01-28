import java.util.Scanner;

public class Main {
	static int[] coin = {500, 100, 50, 10, 5, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int change = 1000 - N;

		int num = 0;
		int k = 0;
		while (change > 0) {
			if (change >= coin[k]) {
				change -= coin[k];
				num++;
			} else {
				k++;
			}
		}

		System.out.println(num);
	}
}