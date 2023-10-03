#include <iostream>
#include <vector>

using namespace std;

int bino[201][201];

// 코드 9.9 k번째 신호를 계산하는 알고리즘

// n개의 -, m개의 o로 구성된 신호 중 skip개를 건너뛰고
// 만들어지는 신호를 반환한다.
string kth(int n, int m, int skip) {
    // n == 0인 경우 나머지 부분은 전부 o일 수밖에 없다.
    if (n == 0) return string(m, 'o');
    if (skip < bino[n + m - 1][n - 1])
        return "-" + kth(n - 1, m, skip);
    return "o" + kth(n, m - 1, skip - bino[n + m - 1][n - 1]);
}
