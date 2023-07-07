#include <iostream>
#include <vector>

using namespace std;

const int MIN = numeric_limits<int>::min();

// A[]]의 연속된 부분 구간의 최대 합을 구한다
int fastestMaxSum(const vector<int> &A) {
    int N = A.size(), ret = MIN, psum = 0;
    for (int i = 0; i < N; ++i) {
        psum = max(psum, 0) + A[i];
        ret = max(psum, ret);
    }
    return ret;
}