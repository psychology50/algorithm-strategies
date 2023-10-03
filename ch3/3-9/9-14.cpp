#include <iostream>
#include <vector>

using namespace std;

// 코드 9.14 순열의 사전순 번호 찾기

// factorials[i] = i!
int factorials[12];
// X가 [0..n-1]의 순열일 때 사전순 번호를 반환한다. (0부터 시작)
int getIndex(const vector<int>& X) {
    int n = X.size();
    int ret = 0;
    for (int i = 0; i < n; ++i) {
        int less = 0;
        // X[i]보다 작은 수가 몇 개 있는지 센다. 이것이 X 앞에 오는 묶음의 수가 된다.
        for (int j = 0; j < n; ++j)
            if (X[j] < X[i])
                ++less;
        ret += factorials[n - i - 1] * less;
    }
    return ret;
}