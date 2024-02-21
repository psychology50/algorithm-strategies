import java.util.Arrays;

public class Main {
	//n개의 음수와 양수를 포함하는 정수 배열 A가 있다.
	//합이 주어진 숫자 k와 일치하는 모든 정수 쌍을 구하라.
	//O(n제곱) 알고리즘은 허용되지 않는다. -> 정렬된 리스트를 한 번의 scan으로 모든 해를 구할 수 있어야 한다.
	//Random클래스를 이용하여 -1000000부터 1000000까지의 정수 100000개를 생성한다. seed는 0으로 설정
	public static void main(String[] args) {
		int[] A = {-5, -2, 5, 4, 3, 7, 2, 1, -1, -2, 15, 6, 12, -4, 3};
		int k = 10;
		//출력: (-5,15) (-2,12) (3,7) (4,6)

		Arrays.sort(A);
		int start = 0;
		int end = A.length - 1;

		while (start < end) {
			int num = A[start] + A[end];
			if (num == k) {
				System.out.printf("%d" + "%d", A[start], A[end]);
				start += 1;
				end -= 1;
			} else if (num < k) {
				start += 1;
			} else {
				end -= 1;
			}
		}


	}
}