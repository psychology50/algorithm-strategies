import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static char[] allNumbers;
	static int[] containNumbers;
	static int[] myArr;
	static int checkCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int allLength = Integer.parseInt(st.nextToken());
		int partLength = Integer.parseInt(st.nextToken());
		checkCount = 0;

		allNumbers = br.readLine().toCharArray();

		containNumbers = new int[4];
		myArr = new int[4];
		int resultCount = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			containNumbers[i] = Integer.parseInt(st.nextToken());
			if (containNumbers[i] == 0) {
				checkCount++; //확인할 문자의 갯수가 0이먄 check된 거나 마찬가지
			}
		}

		for (int i = 0; i < partLength; i++) {
			addNumber(allNumbers[i]);
		}

		if (checkCount == 4) {
			resultCount++;
		}

		// 슬라이딩 윈도우
		for (int i = partLength; i < allLength; i++) {
			int j = i - partLength;
			addNumber(allNumbers[i]);
			removeNumber(allNumbers[j]);
			if (checkCount == 4) {
				resultCount++;
			}
		}

		System.out.println(resultCount);
		br.close();

	}

	private static void addNumber(char number) {
		switch (number) {
			case 'A':
				myArr[0]++;
				if (myArr[0] == containNumbers[0]) {
					checkCount++;
				}
				break;
			case 'C':
				myArr[1]++;
				if (myArr[1] == containNumbers[1]) {
					checkCount++;
				}
				break;
			case 'G':
				myArr[2]++;
				if (myArr[2] == containNumbers[2]) {
					checkCount++;
				}
				break;
			case 'T':
				myArr[3]++;
				if (myArr[3] == containNumbers[3]) {
					checkCount++;
				}
				break;
		}
	}

	private static void removeNumber(char number) {
		switch (number) {
			case 'A':
				if (myArr[0] == containNumbers[0]) {
					checkCount--;
				}
				myArr[0]--;
				break;
			case 'C':
				if (myArr[1] == containNumbers[1]) {
					checkCount--;
				}
				myArr[1]--;
				break;
			case 'G':
				if (myArr[2] == containNumbers[2]) {
					checkCount--;
				}
				myArr[2]--;
				break;
			case 'T':
				if (myArr[3] == containNumbers[3]) {
					checkCount--;
				}
				myArr[3]--;
				break;
		}
	}

}