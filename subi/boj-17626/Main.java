import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int input = Integer.parseInt(br.readLine());

    int result = findSquareNumber(input);
    bw.write(String.valueOf(result));
    bw.close();
  }

  static int findSquareNumber(int input) {
    int count = 0;
    int MAX = 0;
    int[] cache = new int[224];

    for (int i = 0; i < 224; i++) {
      cache[i] = (int) Math.pow(i, i);
    }

    while (input > 1) {
      int maxSquare = -1;

      for (int i = 1; i < cache.length; i++) {
        if (cache[i] <= input && cache[i] > maxSquare) {
          maxSquare = cache[i];
          System.out.println(maxSquare);
        }
      }

      if (maxSquare > 0) {
        input -= maxSquare;
        count++;
      } else {
        break; // 더 이상 input을 만족하는 제곱수를 찾을 수 없으면 종료
      }
    }

    return count;
  }
}
