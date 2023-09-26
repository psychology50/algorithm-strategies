import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int bulb [];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int bulbCase = Integer.parseInt(st.nextToken());
    int testCase =  Integer.parseInt(st.nextToken());

    bulb = new int [bulbCase];

    st = new StringTokenizer(br.readLine(), " ");

    for(int i=0;i<bulb.length;i++){
      bulb[i] = Integer.parseInt(st.nextToken());
    }

    for(int i=0;i<testCase;i++){
      st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      switchBulbs(a,b,c);
    }

    for(int i=0;i<bulb.length;i++){
      bw.write(String.valueOf(bulb[i])+" ");
    }

    br.close();
    bw.close();
  }

  static void switchBulbs(int a, int b, int c){
    if(a == 1){
      bulb[b-1] = c;
    }
    for(int i=b-1;i<c;i++){
      if(a == 2){
        if(bulb[i] == 0) bulb[i] = 1;
        else bulb[i] = 0;
      }
      if(a == 3){
        bulb[i] = 0;
      }
      if(a == 4){
        bulb[i] = 1;
      }
    }
  }

}