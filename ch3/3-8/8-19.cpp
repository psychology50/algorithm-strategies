#include <iostream>
#include <vector>

using namespace std;

// 8.19 비대칭 타일링 문제를 해결하는 동적 계획법 알고리즘

// 2 * width 크기의 사각형을 채우는 비대칭 방법의 수를 반환한다.
int asymmetric (int width) {
    if (width % 2 == 1)
        return (tiling(width) - tiling(width / 2) + MOD) % MOD;
    int ret = tiling(width);
    ret = (ret - tiling(width / 2) + MOD) % MOD;
    ret = (ret - tiling(width / 2 - 1) + MOD) % MOD;
    return ret;
}
