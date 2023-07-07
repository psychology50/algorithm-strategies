#include <iostream>
#include <vector>

using namespace std;

// A의 각 원소가 0부터 100 사이의 값일 경우 가장 많이 등장하는 숫자를 반환한다.
int majority2(const vector<int> &A) {
    int N = A.size();
    vector<int> count(101, 0);

    for (int i = 0; i < N; ++i)
        count[A[i]]++;

    // 지금까지 확인한 숫자 중 빈도수가 제일 큰 것을 majority에 저장한다.
    int majority = 0;
    for (int i = 1; i <= 100; i++)
        if (count[i] > count[majority])
            majority = i;

    return majority;
}