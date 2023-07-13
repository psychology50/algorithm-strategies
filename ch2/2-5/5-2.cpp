#include <iostream>
#include <vector>

using namespace std;

// 코드 5.2 (불변식이 추가된) 삽입 정렬 알고리즘

void insertionSort(vector<int>& A) {
    for (int i = 0; i < A.size(); ++i) {
        // 불변식 a: A[0..i-1]는 이미 정렬되어 있다.
        // A[0..i-1]에 A[i]를 끼워넣는다.
        int j = i;
        while (j > 0 && A[j - 1] > A[j]) {
            // 불변식 b: A[j+1..i]의 모든 원소는 A[j]보다 크다.
            // 불변식 c: A[0..i] 구간은 A[j]를 제외하면 정렬되어 있다.
            swap(A[j - 1], A[j]);
            j--;
        }
    }
}