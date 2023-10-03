#include <iostream>
#include <vector>

using namespace std;

// 코드 9.4 광학 문자 인식 문제를 해결하는 동적 계획법 알고리즘

int n, m;
// 분류기가 반환한 문장. 단어 번호로 변환되어 있음
int R[100];
// T[i][j]=i 단어 이후에 j 단어가 나올 확률의 로그값
double T[501][501];
// M[i][j]=i 단어가 j 단어로 분류될 확률의 로그값
double M[501][501];
int choice[102][502];
double cache[102][502]; // 1로 초기화

// Q[segment] 이후를 채워서 얻을 수 있는 최대 g() 곱의 로그 값을 반환한다.
// Q[segment - 1] == previousMatch라고 가정한다.
double recognize(int segment, int previousMatch) {
    // 기저 사례: 모든 단어를 처리했을 때
    if (segment == n) return 0;
    double& ret = cache[segment][previousMatch];
    if (ret != 1.0) return ret;
    ret = -1e200; // log(0) = 음의 무한대에 가까운 값
    int& choose = choice[segment][previousMatch + 1];

    // R[segment]에 대응되는 단어를 찾는다.
    for (int thisMatch = 0; thisMatch < m; ++thisMatch) {
        // g(thisMatch) = T(previousMatch, thisMatch) * M(thisMatch, R[segment])
        double cand = T[previousMatch][thisMatch] + M[thisMatch][R[segment]] + recognize(segment + 1, thisMatch);
        if (ret < cand) {
            ret = cand;
            choose = thisMatch;
        }
    }
    return ret;
}