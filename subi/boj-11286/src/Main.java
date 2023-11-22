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
			//같으면 음수 우선
			if (firstAbs == secondAbs) {
				return o1 > o2 ? 1 : -1;
			}
			return firstAbs - secondAbs;
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