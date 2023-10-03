#include <iostream>
#include <vector>

using namespace std;

// 코드 9.27 회전초밥 문제를 해결하는 반복적 동적 계획법 알고리즘

int n, m, price[20], pref[20];
int c[201];
// 최대 선호도의 합을 반환한다.
// m과 price[]는 이미 100으로 나뉘어 있다고 있다고 가정한다.
int sushi3() {
    int ret = 0;
    c[0] = 0;
    for (int budget = 1; budget <= m; ++budget) {
        int cand = 0;
        for (int dish = 0; dish < n; ++dish)
            if (budget >= price[dish])
                cand = max(cand, c[(budget - price[dish]) % 201] + pref[dish]);
        c[budget % 201] = cand;
        ret = max(ret, cand);
    }
    return ret;
}
