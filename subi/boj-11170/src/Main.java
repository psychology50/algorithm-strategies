import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

   static int min, max;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int CASE = Integer.parseInt(br.readLine());
    int result [] = new int [CASE];

    for(int i=0;i<CASE;i++){
      st = new StringTokenizer(br.readLine()," ");
      min = Integer.parseInt(st.nextToken());
      max = Integer.parseInt(st.nextToken());
      result [i] = countZero();
    }

    for(int i=0;i<CASE;i++) {
      System.out.println(result[i]);
    }

    br.close();
  }

  static int countZero(){

    List<Integer> inputNumbers = new ArrayList<>();
    int count = 0;

    for(int i=min; i<=max; i++){
      String[] input = Integer.toString(i).split("");
      for (String s : input) {
        inputNumbers.add(Integer.valueOf(s));
      }
    }

    for(int i=0;i<inputNumbers.size();i++){
        if(inputNumbers.get(i) == 0){
           count++;
        }
    }
    return count;
  }

}