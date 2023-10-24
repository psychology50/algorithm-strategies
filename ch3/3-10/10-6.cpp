#include <iostream>
#include <vector>
#include <algorithm>

#define pi 2.0 * acos(0.0)

using namespace std;

int solveLinear(double, double);

// 코드 10.6 미나스 아노르 문제를 선형 문제로 변환해서 푸는 알고리즘

const int INF = 987654321;
int n;
pair<double, double> ranges[100]; // 각 원이 덮는 중심각의 구간
// 0을 덮을 구간을 선택하고 나머지를 선형으로 푼다.
int solveCircular() {
    int ret = INF;
    // 각 구간을 시작 위치의 오름차순으로 정렬한다
    sort(ranges, ranges + n);
    // 카운터를 이용해 반복적으로 최적해를 계산한다
    for (int i = 0; i < n; ++i)
        if (ranges[i].first <= 0 || ranges[i].second >= 2*pi) {
            // 이 구간이 덮는 부분을 빼고 남는 중심각의 범위는 다음과 같다.
            double begin = fmod(ranges[i].second, 2*pi);
            double end = fmod(ranges[i].first + 2*pi, 2*pi);
            // [begin, end] 선분을 주어진 구간을 사용해서 덮는다.
            ret = min(ret, 1 + solveLinear(begin, end));
        }
    return ret;
}
