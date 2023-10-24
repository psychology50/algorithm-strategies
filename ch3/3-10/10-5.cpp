#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 코드 10.5 미나스 아노르 문제의 원들을 중심각의 구간으로 바꾸기

const double pi = 2.0 * acos(0.0);
int n;
double y[100], x[100], r[100];
pair<double, double> ranges[100];
void convertToRange() {
    for (int i = 0; i < n; ++i) {
        // -pi ~ pi의 범위를 0 ~ 2pi로 변환한다
        double loc = fmod(2 * pi + atan2(y[i], x[i]), 2 * pi);
        // atan2의 결과가 음수일 수 있으니 0보다 작으면 2pi를 더해준다
        double range = 2.0 * asin(r[i] / 2.0 / 8.0);
        // 시작 위치와 끝 위치를 저장한다
        ranges[i] = make_pair(loc - range, loc + range);
    }
    sort(ranges, ranges + n);
}
