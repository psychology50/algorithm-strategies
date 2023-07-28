#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// 카라츠바의 빠른 정수 곱셈 알고리즘을 이용해 팬미팅 문제를 해결하는 함수

vector<int> karatsuba(vector<int>& a, vector<int>& b);

int hugs(const string& members, const string& fans) {
    int N = members.size(), M = fans.size();
    vector<int> A(N), B(M);
    for (int i = 0; i < N; ++i) A[i] = (members[i] == 'M');
    for (int i = 0; i < M; ++i) B[M - i - 1] = (fans[i] == 'M');
    // 카라츠바 알고리즘에서 자리 올림은 생략한다
    vector<int> C = karatsuba(A, B);
    int allHugs = 0;
    for (int i = N - 1; i < M; ++i)
        if (C[i] == 0)
            ++allHugs;
    return allHugs;
}