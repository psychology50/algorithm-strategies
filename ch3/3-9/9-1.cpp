#include <iostream>
#include <vector>

using namespace std;

// 코드 9.1 최대 증가 부분 수열을 실제로 계산하기

int n;
int cache[101], S[100], choices[101];

// S[start]에서 시작하는 증가 부분 수열 중 최대 길이를 반환한다.
int lis4(int start) {
    // 메모이제이션
    int& ret = cache[start + 1];
    if (ret != -1) return ret;
    // 항상 S[start]는 있기 때문에 길이는 최하 1
    ret = 1;
    int bestNext = -1;
    for (int next = start + 1; next < n; ++next)
        if (start == -1 || S[start] < S[next]) {
            int cand = lis4(next) + 1;
            if (cand > ret) {
                ret = cand;
                bestNext = next;
            }
        }
    choices[start + 1] = bestNext;
    return ret;
}

// S[start]에서 시작하는 LIS를 seq에 저장한다.
void reconstruct(int start, vector<int>& seq) {
    if (start != -1) seq.push_back(S[start]);
    int next = choices[start + 1];
    if (next != -1) reconstruct(next, seq);
}
