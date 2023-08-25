#include <iostream>
#include <vector>

using namespace std;

// 코드 8.2 메모이제이션을 이용한 이항 계수의 계산

// -1로 초기화해 둔다.
int cache[30][30];
int bino2(int n, int r) {
    // 기저 사례
    if (r == 0 || n == r) return 1;
    // -1이 아니라면 한 번 계산했던 값이니 곧장 반환
    if (cache[n][r] != -1) return cache[n][r];
    // 직접 계산한 뒤 배열에 저장
    return cache[n][r] = bino2(n - 1, r - 1) + bino2(n - 1, r);
}