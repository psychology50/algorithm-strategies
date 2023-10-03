#include <iostream>
#include <vector>

using namespace std;

// 코드 9.23 삼각형 위의 최대 경로의 수를 세는 반복적 동적 계획법 알고리즘

int n, triangle[100][100];
int C[100][100];
int iterative() {
    // 기저 사례를 계산한다.
    for (int x = 0; x < n; ++x)
        C[n - 1][x] = triangle[n - 1][x];
    // 다른 부분을 계산한다.
    for (int y = n - 2; y >= 0; --y)
        for (int x = 0; x <= y; ++x)
            C[y][x] = max(C[y + 1][x], C[y + 1][x + 1]) + triangle[y][x];
    return C[0][0];
}

