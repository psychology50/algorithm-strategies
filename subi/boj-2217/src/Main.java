import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}

		Collections.sort(list, Collections.reverseOrder());

		int max = 0;
		int count = 1;
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			sum = list.get(i) * count;
			if (max <= sum) {
				max = sum;
			}
			count++;
		}

		System.out.println(max);
	}
}