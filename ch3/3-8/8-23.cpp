#include <iostream>
#include <vector>

using namespace std;

// 코드 8.23 두니발 박사의 탈옥 문제를 해결하는 동적 계획법 알고리즘

int n, d, p, q;
// cache[][]는 -1로 초기화해 둔다
double cache[51][101];
// connected[i][j] = 마을 i, j가 연결되어 있나 여부
// deg[i] = 마을 i와 연결된 마을의 개수
double connected[51][51], deg[51];
// days일째에 here번 마을에 숨어 있다고 가정하고,
// 마지막 날에 q번 마을에 숨어 있을 조건부 확률을 반환한다
double search2(int here, int days) {
    // 기저 사례: d일이 지난 경우
    if (days == d) return (here == q ? 1.0 : 0.0);
    // 메모이제이션
    double& ret = cache[here][days];
    if (ret > -0.5) return ret;
    ret = 0.0;
    for (int there = 0; there < n; ++there)
        if (connected[here][there])
            ret += search2(there, days + 1) / deg[here];
    return ret;
}