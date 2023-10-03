#include <iostream>
#include <vector>

using namespace std;

// 코드 9.6 모든 모스 신호를 만드는 완전 탐색 알고리즘

// s: 지금까지 만든 신호
// n: 더 필요한 -의 수
// m: 더 필요한 o의 수
void generate(int n, int m, string s) {
    // 기저 사례: n = m = 0
    if (n == 0 && m == 0) {
        cout << s << endl;
        return;
    }
    if (n > 0) generate(n - 1, m, s + "-");
    if (m > 0) generate(n, m - 1, s + "o");
}