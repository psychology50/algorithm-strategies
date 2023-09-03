import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int cache[][]= new int[30][30];
  static int n = 0, m = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int testCase = Integer.parseInt(br.readLine());


    for(int i=0;i<testCase;i++){
      StringTokenizer s = new StringTokenizer(br.readLine());
      n = Integer.parseInt(s.nextToken());
      m = Integer.parseInt(s.nextToken());
      bw.write(String.valueOf(findNumber(m,n)));
      bw.newLine(); // 결과 출력 후 줄 바꿈
    }
    br.close();
    bw.close();
  }


  static int findNumber(int n,int r){
    if(n == r || r == 0) return 1; //기저 사례
    if(cache[n][r]!= 0) return cache[n][r];
    return cache[n][r] = findNumber(n-1,r-1) + findNumber(n-1, r);
  }

}
