import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	//휴대폰 번호를 입력받는데, 입력 문자열이 '010-ddd-ddd'이 아닌 경우 오류를 출력하라. (d 는 0~9 사이의 숫자)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> s = new ArrayList<>();

		while (!sc.hasNext()) {
			s.add(sc.next());
		}

		String regex = "^010-\\d(4)-\\d(4)$";

		for (String data : s) {
			if (data.matches(regex)) {
				System.out.println("정확한 전화번호 양식입니다.");
			} else {
				System.out.println("잘못된 전화번호 양식입니다.");
			}

		}


	}
}