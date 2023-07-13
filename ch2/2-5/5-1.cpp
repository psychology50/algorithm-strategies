#include <iostream>
#include <vector>

using namespace std;

// 코드 5.1 이진 탐색

// 필수 조건: A는 오름차순으로 정렬되어 있다
// 결과: A[i-1] < x ≤ A[i]인 i를 반환한다
// 이때 A[-1] = -∞, A[n] = +∞라고 가정한다
int binarySearch(const vector<int>& A, int x) {
    int n = A.size();
    int lo = -1, hi = n;
    // 반복문 불변식 1: lo < hi
    // 반복문 불변식 2: A[lo] < x ≤ A[hi]
    // (*) 불변식은 여기서 성립해야 한다.
    while (lo + 1 < hi) {
        int mid = (lo + hi) / 2;
        if (A[mid] < x)
            lo = mid;
        else
            hi = mid;
        // (**) 불변식은 여기서도 성립해야 한다. 
    }
    return hi;
}