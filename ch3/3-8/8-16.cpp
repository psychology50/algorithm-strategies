#include <iostream>
#include <vector>

using namespace std;

// 코드 8.16 타일링의 수를 세는 동적 계획법 알고리즘

const int MOD = 1000000007;
int cache[101];
// 2 * width 크기의 사각형을 채우는 비대칭 방법의 수를 MOD로 나눈 나머지를 반환한다
int tiling(int width) {
    // 기저 사례: width가 1 이하일 때
    if (width <= 1) return 1;
    // 메모이제이션
    int& ret = cache[width];
    if (ret != -1) return ret;
    return ret = (tiling(width - 2) + tiling(width - 1)) % MOD;
}