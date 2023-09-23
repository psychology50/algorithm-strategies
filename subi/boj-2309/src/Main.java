import java.io.*;
import java.util.*;

public class Main {

  static List<Integer> dwarf = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int i = 0; i < 9; i++) {
      int height = Integer.parseInt(br.readLine());
      dwarf.add(height);
    }

    findDwarf(bw);

    br.close();
    bw.close();
  }

  static void findDwarf(BufferedWriter bw) throws IOException {
    for (int i = 0; i < 9; i++) {
      for (int j = i + 1; j < 9; j++) {
        int sum = 0;
        List<Integer> selectedDwarfs = new ArrayList<>();

        // dwarf 리스트에서 i와 j가 아닌 값을 selectedDwarfs 리스트에 추가해준다.
        for (int k = 0; k < 9; k++) {
          if (k != i && k != j) {
            sum += dwarf.get(k);
            selectedDwarfs.add(dwarf.get(k));
          }
        }

        if (sum == 100) {
          // 합이 100인 난쟁이들의 전체 값을 출력한다.
          Collections.sort(selectedDwarfs);
          for (int dwarfHeight : selectedDwarfs) {
            bw.write(String.valueOf(dwarfHeight) + "\n");
          }
          return;
        }
      }
    }

  }
}
