#include <iostream>
#include <vector>

using namespace std;

// 코드 6.1 1부터 n까지의 합을 계산하는 반복 함수와 재귀 함수

// 필수 조건: n >= 1
// 결과: 1부터 n까지의 합을 반환한다.
int sum(int n) {
    int ret = 0;
    for (int i=1; i<=n; i++)
        ret += i;
    return ret;
}

// 필수 조건: n >= 1
// 결과: 1부터 n까지의 합을 반환한다.
int recursiveSum(int n) {
    if (n == 1) return 1; // 기저 사례: n = 1일 때
    return n + recursiveSum(n - 1);
}