import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int min,max;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int CASE = Integer.parseInt(br.readLine());

    for(int i=0;i<CASE;i++){
      st = new StringTokenizer(br.readLine()," ");
      min = Integer.parseInt(st.nextToken());
      max = Integer.parseInt(st.nextToken());
    }


    br.close();
  }
}