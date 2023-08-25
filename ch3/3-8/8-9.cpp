#include <iostream>
#include <vector>

using namespace std;

// 코드 8.9 삼각형 위의 최대 경로 문제를 푸는 동적 계획법 알고리즘 (2)

int n, triangle[100][100];
int cache2[100][100];
// (y, x) 위치부터 맨 아래줄까지 내려가면서 얻을 수 있는 최대 경로를 반환한다
int path2(int y, int x) {
    // 기저 사례
    if (y == n - 1) return triangle[y][x];
    // 메모이제이션
    int& ret = cache2[y][x];
    if (ret != -1) return ret;
    return ret = max(path2(y + 1, x), path2(y + 1, x + 1)) + triangle[y][x];
}
