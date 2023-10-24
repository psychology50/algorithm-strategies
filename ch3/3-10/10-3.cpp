#include <iostream>
#include <vector>
#include <algorithm>

#define MAX_N 1000

using namespace std;

// 코드 10.3 도시락 데우기 문제를 해결하는 탐욕적 알고리즘

int n, e[MAX_N], m[MAX_N];
int heat() {
    // 어느 순서로 데워야 할지를 정한다.
    vector<pair<int, int>> order;
    for (int i = 0; i < n; ++i)
        order.push_back(make_pair(-e[i], i));
    sort(order.begin(), order.end());
    // 해당 순서대로 데워먹는 과정을 시뮬레이션한다.
    int ret = 0, beginEat = 0;
    for (int i = 0; i < n; ++i) {
        // 데우는 시간과 먹는 시간을 더한다.
        int box = order[i].second;
        beginEat += m[box];
        ret = max(ret, beginEat + e[box]);
    }
    return ret;
}