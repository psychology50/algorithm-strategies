public class Main {
	public static void main(String[] args) {
		//문자열이 고유 문자만 포함될 경우 true를 반환하는 코드를 작성하라. 단, 공백은 무시한다.
		//trim 쓰면 중간 공백은?
		//substirng = n,n-1,n-2번 비교 -> n제곱 알고리즘
		//방법 : set에 넣어서 크기가 같으먄 중복이 없는 것 -> 모든 게 n 알고리즘 (set안에서 중복체크는 hashing을 사용하므로 n제곱은 아니다)
		String s = "abcde";
		if (pattern(s)) {
			System.out.println(s);
		}
		System.out.println("FALSE");
	}

	public static boolean pattern(String s) {
		if (s.contains("q")) {
			return true;
		}
		return false;
	}
}