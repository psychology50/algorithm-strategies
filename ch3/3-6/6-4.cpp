#include <iostream>
#include <vector>

using namespace std;

// 코드 6.4 소풍 문제를 해결하는 (잘못된) 재귀 호출 코드

int n;
bool areFriends[10][10];
// taken[i] = i번째 학생이 짝을 이미 찾았으면 true, 아니면 false
int countPairings(bool taken[10]) {
    // 기저 사례: 모든 학생이 짝을 찾았으면 한 가지 방법을 찾았으니 종료한다.
    bool finished = true;
    for (int i = 0; i < n; ++i) if (!taken[i]) finished = false;
    if (finished) return 1;
    int ret = 0;

    // 서로 친구인 두 학생을 찾아 짝을 지어 준다.
    for (int i = 0; i < n; ++i) {
        for (int j = i+1; j < n; ++j) {
            if (!taken[i] && !taken[j] && areFriends[i][j]) {
                taken[i] = taken[j] = true;
                ret += countPairings(taken);
                taken[i] = taken[j] = false;
            }
        }
    }
    return ret;
}