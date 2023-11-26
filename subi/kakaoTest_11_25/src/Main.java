import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {

		String[] friends = new String[4];
		String[] gitts = new String[8];

		friends[0] = "m";
		friends[1] = "r";
		friends[2] = "f";
		friends[3] = "n";


		gitts[0] = "m f";
		gitts[1] = "m f";
		gitts[2] = "r m";
		gitts[3] = "r m";
		gitts[4] = "r m";
		gitts[5] = "f m";
		gitts[6] = "f r";
		gitts[7] = "n m";

		System.out.println(solution(friends, gitts));

	}


	public static int solution(String[] friends, String[] gifts) {
		int answer = 0;
		StringTokenizer st;

		int gift[][] = new int[friends.length][friends.length];
		int giftStock[] = new int[friends.length];
		int count[] = new int[friends.length];

		for (int i = 0; i < gifts.length; i++) {
			String giftName = gifts[i];
			st = new StringTokenizer(giftName);
			String nameA = st.nextToken();
			String nameB = st.nextToken();
			++gift[Arrays.asList(friends).indexOf(nameA)][Arrays.asList(friends).indexOf(nameB)];
		}

		for (int i = 0; i < gift.length; i++) {
			int rowNum = 0, colNum = 0, temp = 0;
			for (int j = 0; j < gift.length; j++) {
				rowNum += gift[i][j];
				colNum += gift[j][i];
			}
			temp = rowNum - colNum;
			giftStock[i] = temp;
		}

		for (int from = 0; from < gift.length; from++) {
			for (int to = 0; to < gift.length; to++) {
				if (from == to) continue;

				if (gift[from][to] > gift[to][from]) {
					count[from]++;
				} else if (gift[from][to] == gift[to][from]) {
					if (giftStock[from] > giftStock[to]) {
						count[from]++;
					} else if (giftStock[to] < giftStock[from]) {
						count[to]++;
					}
				}

			}
		}

		for (int i = 0; i < count.length; i++) {
			answer = Math.max(answer, count[i]);
		}
		return answer;
	}
}

