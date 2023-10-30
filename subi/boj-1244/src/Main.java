import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int switches [];
  static int SWITCHCASE;

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    SWITCHCASE = Integer.parseInt(br.readLine());

    //switch문이 있으므로 변수명으로 switch를 써줄 수 없음
    switches = new int [SWITCHCASE];

    st = new StringTokenizer(br.readLine(), " ");

    for(int i=0;i<SWITCHCASE;i++){
      switches[i] = Integer.parseInt(st.nextToken());
    }

    int STUDENTNUM = Integer.parseInt(br.readLine());

    for(int i=0;i<STUDENTNUM;i++){
      st = new StringTokenizer(br.readLine(), " ");
      int gen = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      switchStatus(gen,num);
    }

//한 줄에 20개씩 출력
    for(int i=0; i<SWITCHCASE; i++) {
      System.out.print(switches[i] + " ");
      if((i+1) % 20 == 0)
        System.out.println();
    }

    bw.flush();
    br.close();
    bw.close();

  }

  static void switchStatus(int gen, int num){
    if(gen == 1){
      for(int i=0;i<SWITCHCASE;i++) {
          if((i+1) % num == 0)
            switches[i] = switches[i] == 0? 1: 0;
      }
    }

    if(gen == 2){
      //인덱스는 -1
      switches[num - 1] = switches[num - 1] == 0 ? 1 : 0;

      for(int j=1; j<SWITCHCASE/2; j++) {
        //배열의 범위를 벗어날 때
        if(num - 1 + j >= SWITCHCASE || num - 1 - j < 0)
          break;
        //배열의 범위가 그대로면
        if(switches[num - 1 - j] == switches[num - 1 + j]) {
          switches[num - 1 - j] = switches[num - 1 - j] == 0 ? 1 : 0;
          switches[num - 1 + j] = switches[num - 1 + j] == 0 ? 1 : 0;
        }
        else break; //대칭 아닌것이 나오면 바로 끝낸다.
      }
    }

  }

}