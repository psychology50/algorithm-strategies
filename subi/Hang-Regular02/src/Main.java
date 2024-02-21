import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//02/21/2023 을 YYYYMMDD (20230221) 형태로 변경하여 출력해라.

public class Main {
	public static void main(String[] args) {
		System.out.print("날짜를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		String regex = "(\\d{2})(\\d{2})(\\d{4})";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);

		m.find();
		System.out.printf("%s\n", m.group(3) + m.group(1) + m.group(2));

		sc.close();
	}
}