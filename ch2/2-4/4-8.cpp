#include <iostream>
#include <vector>

using namespace std;

void selectionSort(vector<int> &A) {
    for (int i = 0; i < A.size(); ++i) {
        int minIndex = i;
        for (int j = i + 1; j < A.size(); ++j)
            if (A[j] < A[minIndex])
                minIndex = j;
        swap(A[i], A[minIndex]);
    }
}

void insertionSort(vector<int> &A) {
    for (int i = 0; i < A.size(); ++i) {
        // A[0..i-1]에 A[i]를 끼워넣는다.
        int j = i;
        while (j > 0 && A[j - 1] > A[j]) {
            swap(A[j - 1], A[j]);
            j--;
        }
    }
}