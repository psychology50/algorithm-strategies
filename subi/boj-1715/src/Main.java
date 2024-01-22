import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			queue.add(Integer.parseInt(br.readLine()));
		}

		int sum = 0;
		while (queue.size() > 1) {
			int a = queue.poll();
			int b = queue.poll();
			sum += a + b;
			queue.offer(a + b);
		}

		System.out.println(sum);
	}

}