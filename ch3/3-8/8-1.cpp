#include <iostream>
#include <vector>

using namespace std;

// 코드 8.1 재귀 호출을 이용한 이항 계수의 계산

int bino(int n, int r) {
    // 기저 사례: n = r (모든 원소를 다 고르는 경우) 또는 r = 0 (고를 원소가 없는 경우)
    if (r == 0 || n == r) return 1;
    return bino(n - 1, r - 1) + bino(n - 1, r);
}