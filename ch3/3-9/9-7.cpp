#include <iostream>
#include <vector>

using namespace std;

// 코드 9.7 k-1개 건너뛰고 첫 번째 신호를 출력하는 알고리즘

int skip;
// skip개를 건너뛰고 출력한다.
void generate2(int n, int m, string s) {
    // 기저 사례: skip < 0
    if (skip < 0) return;
    // 기저 사례: n = m = 0
    if (n == 0 && m == 0) {
        // 더 건너뛸 신호가 없는 경우
        if (skip == 0) cout << s << endl;
        --skip;
        return;
    }
    if (n > 0) generate2(n - 1, m, s + "-");
    if (m > 0) generate2(n, m - 1, s + "o");
}