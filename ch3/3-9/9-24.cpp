#include <iostream>
#include <vector>

using namespace std;

// 코드 9.24 슬라이딩 윈도를 이용한 삼각형 위의 최대 경로 알고리즘

int n, triangle[100][100];
int C2[2][10000];
int iterative2() {
    // 기저 사례를 계산한다.
    for (int x = 0; x < n; ++x)
        C2[(n - 1) % 2][x] = triangle[n - 1][x];
    // 다른 부분을 계산한다.
    for (int y = n - 2; y >= 0; --y)
        for (int x = 0; x <= y; ++x)
            C2[y % 2][x] = max(C2[(y + 1) % 2][x], C2[(y + 1) % 2][x + 1]) + triangle[y][x];
    return C2[0][0];
}

