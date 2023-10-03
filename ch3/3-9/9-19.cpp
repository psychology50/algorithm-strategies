#include <iostream>
#include <vector>

using namespace std;

const int MAX_N = 15;
int k;
string word[MAX_N];
int overlap[MAX_N][MAX_N];
int restore(int, int);

// 코드 9.19 실험 데이터 복구 문제의 실제 답을 계산하는 알고리즘

string reconstruct(int last, int used) {
    // 기저 사례
    if (used == (1 << k) - 1) return "";
    for (int next = 0; next < k; ++next) {
        // next 단어를 아직 사용하지 않았다면
        if ((used & (1 << next)) == 0) {
            // next 단어를 사용했을 때 최적해가 나온다면
            int ifUsed = restore(next, used + (1 << next)) + overlap[last][next];
            if (restore(last, used) == ifUsed)
                return (word[next].substr(overlap[last][next]) + reconstruct(next, used + (1 << next)));
        }
    }
    return "****oops****";
}
