#include <iostream>
#include <vector>

using namespace std;

const int MIN = numeric_limits<int>::min();

// A[lo..hi]의 연속된 부분 구간의 최대합을 구한다. (분할 정복)
int fastMaxSum(const vector<int> &A, int lo, int hi) {
    // 기저 사례: 구간의 길이가 1일 경우
    if (lo == hi)
        return A[lo];

    // 배열을 A[lo..mid], A[mid+1..hi]의 두 조각으로 나눈다
    int mid = (lo + hi) / 2;

    // 두 부분에 모두 걸쳐 있는 최대 합 구간을 찾는다. 이 구간은
    // A[i..mid]와 A[mid+1..j] 형태를 갖는 구간의 합으로 이루어진다
    int left = MIN, right = MIN, sum = 0;
    for (int i = mid; i >= lo; --i) {
        sum += A[i];
        left = max(left, sum);
    }
    sum = 0;
    for (int j = mid + 1; j <= hi; ++j) {
        sum += A[j];
        right = max(right, sum);
    }

    // 최대 합 구간이 두 조각 중 하나에만 속해 있는 경우의 답을 재귀 호출을
    // 이용해 찾는다
    int single = max(fastMaxSum(A, lo, mid), fastMaxSum(A, mid + 1, hi));

    // 두 경우 중 최대치를 반환한다
    return max(left + right, single);
}