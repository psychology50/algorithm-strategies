#include <iostream>
#include <vector>

using namespace std;

// 코드 8.20 직접 비대칭 타일링의 수를 세는 동적 계획법 알고리즘

int cache2[101];
// 2 * width 크기의 사각형을 채우는 비대칭 방법의 수를 반환한다
int asymmetric2(int width) {
    // 기저 사례: 너비가 2 이하인 경우
    if (width <= 2) return 0;
    // 메모이제이션
    int& ret = cache2[width];
    if (ret != -1) return ret;
    ret = asymmetric2(width - 2) % MOD;
    ret = (ret + asymmetric2(width - 4)) % MOD;
    ret = (ret + tiling(width - 3)) % MOD;
    ret = (ret + tiling(width - 3)) % MOD;
    return ret;
}