import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//공백,a~z,0~9등의 문자로 이루어진 문자열을 입력받는다.
	//이 문자열에서 정수를 추출하는 코드를 작성하라.
	//얍력 : cv dd 4 k 2321 2 11 k4k2 66 4d
	//출력: 4,2321,2,11,4,2,66,4
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		String regex = "\\d+";

	}
}