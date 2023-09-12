import java.io.*;

public class Main {

  static int[] cache;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str;
    while ((str = br.readLine()) != null) {
      int input = Integer.parseInt(str);
      int testLength = (int) Math.pow(3, input);
      StringBuilder kanTo = new StringBuilder();

      cache = new int[testLength];

      findKantoSet(0, testLength);

      for (int i = 0; i < testLength; i++) {
        if (cache[i] == 0) kanTo.append('-');
        else kanTo.append(' ');
      }
      bw.write(kanTo.toString());
      bw.write("\n");
    }

    br.close();
    bw.close();
  }

  static void findKantoSet(int start, int length) {
    // 기저 사례
    if (length == 1) return;

    int divideSize = length / 3;

    // 3등분한 문자열 공백 부분 처리
    for (int i = start + divideSize; i < start + 2 * divideSize; i++) {
      cache[i] = -1;
    }

    findKantoSet(start, divideSize);
    findKantoSet(start + 2 * divideSize, divideSize);
  }
}
