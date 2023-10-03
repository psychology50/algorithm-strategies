#include <iostream>
#include <vector>

using namespace std;

int n, m;
int choice[102][502];

// 코드 9.5 광학 문자 인식 문제의 실제 답 계산하기

// 입력받은 단어들의 목록
string corpus[501];
string reconstruct(int segment, int previousMatch) {
    int choose = choice[segment][previousMatch];
    string ret = corpus[choose];
    if (segment < n - 1)
        ret = ret + " " + reconstruct(segment + 1, choose);
    return ret;
}