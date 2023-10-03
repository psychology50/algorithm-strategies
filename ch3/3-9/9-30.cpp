#include <iostream>
#include <vector>

using namespace std;

// 코드 9.30 지니어스 문제를 해결하는 반복적 동적 계획법

int n, k, length[50];
double T[50][50];
vector<double> getProb1() {
    // c[time][song]=time분 후에 song번 노래가 시작할 확률
    double c[5][50];
    memset(c, 0, sizeof(c));
    c[0][0] = 1.0;
    for (int time = 1; time <= 5; ++time)
        for (int song = 0; song < n; ++song) {
            double& prob = c[time % 5][song];
            prob = 0;
            for (int last = 0; last < n; ++last)
                prob += c[(time - length[last] + 5) % 5][last] * T[last][song];
        }
    vector<double> ret(n);
    // song번 노래가 재생되고 있을 확률을 계산한다.
    for (int song = 0; song < n; ++song) 
        // song번 노래가 시작할 확률을 모두 찾아 더한다.
        for (int start = k-length[song]+1; start < length[song]; ++start)
            ret[song] += c[start % 5][song];
    return ret;
}
