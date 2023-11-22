import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		int arr[] = new int[input];

		for (int i = 0; i < input; i++) {
			arr[i] = sc.nextInt();
		}

		Stack<Integer> stack = new Stack<>();
		int num = 1;
		boolean result = true;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			int currentNum = arr[i];
			if (currentNum >= num) {
				while (num <= currentNum) {
					stack.push(num);
					num++;
					sb.append("+\n");
				}
				stack.pop(); // 맨 마지막 입력 값 출력
				sb.append("-\n");
			} else {
				int n = stack.pop();
				if (currentNum < n) { //작다면
					System.out.println("NO");
					result = false;
					break;
				} else { //같다면 (제일 위에 있다면)
					sb.append("-\n");
				}
			}
		}

		if (result) { // result == true
			System.out.println(sb.toString());
		}

	}
}