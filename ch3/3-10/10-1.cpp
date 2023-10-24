#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 코드 10.1 회의실 예약 문제를 해결하는 탐욕적 알고리즘

// 각 회의는 [begin, end) 구간 동안 회의실을 사용한다.
int n;
int begin[100], end[100];
int schedule() {
    // 일찍 끝나는 순서대로 정렬한다
    vector<pair<int, int> > order;
    for (int i = 0; i < n; ++i)
        order.push_back(make_pair(end[i], begin[i]));
    sort(order.begin(), order.end());
    // earliest: 다음 회의가 시작할 수 있는 가장 빠른 시간
    // selected: 지금까지 선택한 회의의 수
    int earliest = 0, selected = 0;
    for (int i = 0; i < order.size(); ++i) {
        int meetingBegin = order[i].second, meetingEnd = order[i].first;
        if (earliest <= meetingBegin) {
            // earliest를 마지막 회의가 끝난 시간 이후로 갱신하고
            // 선택된 회의에 추가한다
            earliest = meetingEnd;
            ++selected;
        }
    }
    return selected;
}
