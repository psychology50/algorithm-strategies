import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int available_num = Integer.parseInt(st.nextToken());
    int length = Integer.parseInt(st.nextToken());

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    LinkedHashSet<String> set = new LinkedHashSet<>();
    for (int i = 0; i < length; i++) {
      String student = br.readLine();
      if(set.contains(student)) {
        set.remove(student);
      }
      set.add(student);
    }

    Object[] success_student = set.toArray();
    if(success_student.length < available_num){
      available_num = success_student.length;
    }

    for(int i = 0; i < available_num; i++){
      bw.write(success_student[i] + "\n");
    }

    br.close();
    bw.close();
  }
}
