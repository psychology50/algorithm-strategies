import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;

		while (n > 0) {
			if (n % 5 == 0) {
				cnt += n / 5;
				System.out.println(cnt);
				return; //main문을 끝내고 싶으면 return
			} else if (n < 3) {
				System.out.println("-1");
				return;
			}
			n -= 3;
			cnt++;
		}

		System.out.println(cnt);

	}
}
