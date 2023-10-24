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

    int STUDENTNUM = Integer.parseInt (br.readLine());

    for(int i=0;i<STUDENTNUM;i++){
      st = new StringTokenizer(br.readLine(), " ");
      int gen = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());
      switchStatus(gen,num);
    }

    for(int i=0;i<switches.length;i++){
      if(i == 21) {
        bw.write(String.valueOf("\n" + switches[i]));
      }
      if(switches.length == 41) {
        bw.write(String.valueOf("\n" + switches[i]));
      }
      bw.write(String.valueOf(switches[i])+" ");
    }

  }

  static void switchStatus(int gen, int num){
    if(gen == 1){
      for(int i=0;i<SWITCHCASE;i++) {

        if(switches[i] == 1) {
          while(num < SWITCHCASE) {
            switches[num] = 0;
            num *= 2;
          }
        }

        if(switches[i] == 0) {
          while(num < SWITCHCASE) {
            switches[num] = 1;
            num *= 2;
          }
        }

      }
    }

    if(gen == 2){
      for(int i=0;i<SWITCHCASE;i++) {
        int j = 1;

        if(switches[i] == 0){
          switches[num] = 1;
          while(num+j < SWITCHCASE){
            if(switches[num-j] == switches[num+j]) {switches[num-j] =1 ; switches [num+j] = 1; j++;}
          }
        }

        if(switches[i] == 1){
          switches[num] = 0;
          while(num+j < SWITCHCASE){
            if(switches[num-j] == switches[num+j]) {switches[num-j] =0 ; switches [num+j] = 0; j++;}
          }

        }
      }
    }

  }

}