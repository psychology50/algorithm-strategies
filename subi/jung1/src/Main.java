import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n = 0;
	static int[] arr1;
	static int[] arr2;

	static int[][] map1;
	static int[][] map2;

	static int[][] totalMap = new int[n][n];
	static ArrayList<String> list = new ArrayList<>();
	static String[] s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb;

		n = Integer.parseInt(br.readLine());

		arr1 = new int[n];
		arr2 = new int[n];
		map1 = new int[n][n];
		map2 = new int[n][n];
		totalMap = new int[n][n];
		s = new String[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

		sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			sb.append(0);
		}

		for (int i = 0; i < n; i++) {
			String s1 = Integer.toBinaryString(arr1[i]);
			String s2 = Integer.toBinaryString(arr2[i]);
			DecimalFormat df = new DecimalFormat(sb.toString());
			String s1Format = df.format(Integer.parseInt(s1));
			String s2Format = df.format(Integer.parseInt(s2));
			for (int j = 0; j < n; j++) {
				map1[i][j] = Integer.parseInt(s1Format.substring(j, j + 1));
				map2[i][j] = Integer.parseInt(s2Format.substring(j, j + 1));
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map1[i][j] != map2[i][j]) {
					totalMap[i][j] = 1;
				} else {
					totalMap[i][j] = map1[i][j];
				}
			}
		}

		for (int i = 0; i < n; i++) {
			sb = new StringBuffer();
			for (int j = 0; j < n; j++) {
				if (totalMap[i][j] == 1) {
					sb.append("#");
				} else {
					sb.append(" ");
				}
			}
			list.add(i, sb.toString());
		}

		for (int i = 0; i < n; i++) {
			s[i] = list.get(i);
			System.out.print(s[i]);
		}

	}
}