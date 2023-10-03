#include <iostream>
#include <vector>

using namespace std;

const int MAX_BUDGET = 1000000000;

// 코드 9.27 회전초밥 문제를 해결하는 반복적 동적 계획법

int n, m, price[20], pref[20];
int c[MAX_BUDGET+1];
// sushi()를 반복적 동적 계획법으로 구현하기
int sushi2() {
    int ret = 0;
    for (int budget = 1; budget <= m; ++budget) {
        c[budget] = 0;
        for (int dish = 0; dish < n; ++dish)
            if (budget >= price[dish])
                c[budget] = max(c[budget], c[budget - price[dish]] + pref[dish]);
        ret = max(ret, c[budget]);
    }
    return ret;
}
