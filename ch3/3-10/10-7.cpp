#include <iostream>
#include <vector>

using namespace std;

// 코드 10.7 선분을 덮는 최소 구간 수를 계산하는 탐욕적 알고리즘

const int INF = 987654321;
// [begin, end] 구간을 덮기 위해 선택할 최소한의 구간 수를 반환한다.
// ranges는 시작 위치의 오름차순으로 정렬되어 있다고 가정한다.
int solveLinear(double begin, double end, const vector<pair<double, double> >& ranges) {
    int used = 0, idx = 0;
    // 시작 위치를 기준으로 정렬한다.
    while (begin < end) {
        // begin보다 이전에 시작하는 구간 중 가장 늦게 끝나는 구간을 찾는다.
        double maxCover = -1;
        while (idx < ranges.size() && ranges[idx].first <= begin) {
            maxCover = max(maxCover, ranges[idx].second);
            ++idx;
        }
        // 덮을 구간을 찾지 못한 경우
        if (maxCover <= begin) return INF;
        // 구간 [begin, maxCover]를 덮었다고 가정하고 다음 단계를 진행한다.
        begin = maxCover;
        ++used;
    }
    return used;
}
