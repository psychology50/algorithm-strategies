import java.util.Scanner;

public class Main {
	static int[] coin = {500, 100, 50, 10, 5, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int change = 1000 - N;

		int num = 0;

		while (change >= coin[0]) {
			change -= coin[0];
			num++;
		}
		while (change >= coin[1]) {
			change -= coin[1];
			num++;
		}
		while (change >= coin[2]) {
			change -= coin[2];
			num++;
		}
		while (change >= coin[3]) {
			change -= coin[3];
			num++;
		}
		while (change >= coin[4]) {
			change -= coin[4];
			num++;
		}
		while (change >= coin[5]) {
			change -= coin[5];
			num++;
		}


		System.out.println(num);

	}
}