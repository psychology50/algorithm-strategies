#include <iostream>
#include <vector>

using namespace std;

// 코드 7.1 1부터 n까지의 합을 구하는 분할 정복 알고리즘

// 필수 조건: n은 자연수
// 1부터 n까지의 합을 반환한다
int fastSum(int n) {
    // 기저 사례
    if (n == 1) return 1;
    if (n % 2 == 1) return fastSum(n - 1) + n;
    return 2 * fastSum(n / 2) + (n / 2) * (n / 2);
}