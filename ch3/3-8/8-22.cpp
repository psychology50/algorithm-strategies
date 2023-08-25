#include <iostream>
#include <vector>

using namespace std;

// 코드 8.22 두니발 박사의 탈옥 문제를 해결하는 완전 탐색 알고리즘

int n, d, p, q;
// connected[i][j] = 마을 i, j가 연결되어 있나 여부
// deg[i] = 마을 i와 연결된 마을의 개수
double connected[51][51], deg[51];
double search(vector<int>& path) {
    // 기저 사례: d일이 지난 경우
    if (path.size() == d + 1) {
        // 이 시나리오가 q에서 끝나지 않는다면 무효
        if (path.back() != q) return 0.0;
        // path의 출현 확률을 계산한다
        double ret = 1.0;
        for (int i = 0; i + 1 < path.size(); ++i)
            ret /= deg[path[i]];
        return ret;
    }
    double ret = 0;
    // 경로의 다음 위치를 결정한다
    for (int there = 0; there < n; ++there)
        if (connected[path.back()][there]) {
            path.push_back(there);
            ret += search(path);
            path.pop_back();
        }
    return ret;
}