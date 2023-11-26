import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			//절대 값이 다르면 작은 거 우선
			int firstAbs = Math.abs(o1);
			int secondAbs = Math.abs(o2);

			if (firstAbs == secondAbs) { //절대 값 같으면 음수 우선
				return o1 > o2 ? 1 : -1; //o1이 양수 값 o2가 음수 값이라면, 1을 리턴하고 -> 그 말인 즉슨 o2 가 우선순위라는 말
			}

			return firstAbs - secondAbs; // 절대 값이 다를 떄, 앞 값이 더
		});

		for (int i = 0; i < input; i++) {
			int request = Integer.parseInt(br.readLine());
			if (request == 0) {
				if (queue.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(queue.poll());
				}
			} else {
				queue.add(request);
			}
		}

	}
}