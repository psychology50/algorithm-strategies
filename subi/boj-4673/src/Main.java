public class Main {

	static boolean[] check = new boolean[10001];

	public static void main(String[] args) {

		for (int i = 1; i <= 10000; i++) {

			int num = i;
			int sum = num;
			while (num != 0) {
				sum += (num % 10);
				num = num / 10;
			}
			if (sum <= 10000) check[sum] = true;
		}

		for (int i = 1; i <= 10000; i++) {
			if (!check[i]) {
				System.out.println(i);
			}
		}

	}

}