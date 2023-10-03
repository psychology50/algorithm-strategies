#include <iostream>
#include <vector>

using namespace std;

const int MAX = 10;

// 코드 9.15 여행하는 외판원 문제를 해결하는 동적 계획법 알고리즘

int n, dist[MAX][MAX];
double cache[MAX][1 << MAX]; // -1로 초기화
// here: 현재 위치
// visited: 각 도시의 방문 여부
// here에서 시작해 남은 도시들을 방문할 수 있는 최단 경로의 길이를 반환한다.
// 나머지 도시들을 모두 방문하는 경로들 중 가장 짧은 것의 길이를 반환한다.
// 항상 0번 도시에서 시작한다고 가정한다.
double shortestPath2(int here, int visited) {
    // 기저 사례: 모든 도시를 다 방문했을 때는 0번 도시로 돌아가고 종료한다.
    if (visited == (1 << n) - 1) return dist[here][0];
    // 메모이제이션
    double& ret = cache[here][visited];
    if (ret >= 0) return ret;
    ret = 1e200; // 매우 큰 값으로 초기화
    // 다음 방문할 도시를 전부 시도해 본다.
    for (int next = 0; next < n; ++next) {
        // 이미 방문한 도시인 경우
        if (visited & (1 << next)) continue;
        double cand = dist[here][next] + shortestPath2(next, visited + (1 << next));
        ret = min(ret, cand);
    }
    return ret;
}



