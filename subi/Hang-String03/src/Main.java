import java.util.Scanner;

public class Main {
	//2개의 문자열 str1,str2를 입력받는다. str1을 회전하여 str2를 만들 수 있는지 확인하라.
	//helloworld -> elloworldh (회전1번)
	//알고리즘 1: str1의 모든 위치에서 회전 문자열을 만든 다음, str2와 같은지 비교
	//알고리즘 2
	/*
	str1=p1+p2 (임의의 위치에서 나눈 두 개의 문자열의 합)
	str2가 p2+p1일 경우(회전하여 나올 수 있는 문자열일 경우), true
	핵심 아이디어 : str1+str1 = p1+p2+p1+p2 이므로, p2+p1을 포함
	만약 str1 + str1 이 str2를 포함한다면 ture
	(p+q+p+q) 에 str2가 포함된다면 true!
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

	}
}