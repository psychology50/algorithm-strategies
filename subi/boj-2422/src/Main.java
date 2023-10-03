import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static boolean[][] check;
  static int[] select = new int[3];
  static int N,M, count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st= new StringTokenizer(br.readLine()," ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    check = new boolean[N+1][N+1];

    for(int i=0;i<M;i++){
      st = new StringTokenizer(br.readLine()," ");
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      check[n1][n2] = true;
      check[n2][n1] = true;
    }
    //아이스크림 모든 조합 만들기
    for(int i=1;i<=N;i++){
      select[0] = i;
      search(1, i);
    }
    bw.write(String.valueOf(count));
    bw.close();
    br.close();
  }
  static void search(int depth, int index){
    if(depth==3){
      selectCheck();
      return;
    }
    //탐색
    for(int i=index+1;i<=N;i++){
      select[depth] = i;
      search(depth+1, i);
    }
  }
  static void selectCheck(){
    for(int i=0;i<3;i++){
      for(int j=i+1;j<3;j++){
        if(check[select[i]][select[j]])
          return;
      }
    }
    count++;
  }
}