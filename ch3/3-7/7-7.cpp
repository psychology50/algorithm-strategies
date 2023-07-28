#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// 코드 7.8 울타리 잘라내기 문제를 해결하는 O(n^2) 알고리즘

// 판자의 높이를 담은 배열 h[]가 주어질 때 사각형의 최대 너비를 반환한다
int bruteForce(const vector<int>& h) {
    int ret = 0;
    int N = h.size();
    // 가능한 모든 left, right 조합을 순회한다
    for (int left = 0; left < N; left++) {
        int minHeight = h[left];
        for (int right = left; right < N; right++) {
            minHeight = min(minHeight, h[right]);
            ret = max(ret, (right - left + 1) * minHeight);
        }
    }
    return ret;
}