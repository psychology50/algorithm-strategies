import java.util.Scanner;

public class Main {

	//nC4이므로 그냥 풀어서 쓰자.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long result = (n * (n - 1) * (n - 2) * (n - 3)) / 24;
		System.out.println(result);

	}

}