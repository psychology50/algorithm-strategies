import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ArrayList<int[]> arr;

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			arr = new ArrayList<>(); //
			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr.add(new int[] {a, b});
			}

			//오름차순 정렬
			Collections.sort(arr, Comparator.comparingInt((int[] a) -> a[0]));

			int ans = 1; // 서류 1등은 무조건 통과
			int min = arr.get(0)[1]; // 면접 점수 최소값
			for (int j = 1; j < n; j++) { // 서류 2등부터 시작
				if (arr.get(j)[1] < min) { // 이전의 최소 면접 점수보다 낮으면 통과
					ans++;
					min = arr.get(j)[1]; // 최소 점수 갱신
				}
			}
			System.out.println(ans);

		}

	}
}