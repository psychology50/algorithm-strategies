import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	//https://school.programmers.co.kr/learn/courses/30/lessons/17682
	public static void main(String[] args) {

		String dartResult = "1S2D*3T";
		String regux = "(\\d{1,2})([SDT])([#*]?)";
		Pattern p = Pattern.compile(regux);
		Matcher m = p.matcher(dartResult);

		m.find();

		String g1 = m.group(1);
		String g2 = m.group(2);
		String g3 = m.group(3);

		int result = 0;
		g1.contains("*"){
			result = Integer.parseInt();
		}
	}
}