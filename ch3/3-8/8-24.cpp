#include <iostream>
#include <vector>

using namespace std;

// 코드 8.24 두니발 박사의 탈옥 문제를 해결하는 동적 계획법 알고리즘

int n, d, p, q;
double cache[51][101];
double connected[51][51], deg[51];
double search3(int here, int days) {
    // 기저 사례: 0일째
    if (days == 0) return (here == p ? 1.0 : 0.0);
    // 메모이제이션
    double& ret = cache[here][days];
    if (ret > -0.5) return ret;
    ret = 0.0;
    for (int there = 0; there < n; ++there)
        if (connected[here][there])
            ret += search3(there, days - 1) / deg[there];
    return ret;
}
