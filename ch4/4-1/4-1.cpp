#include <iostream>
#include <vector>

using namespace std;

// 주어진 배열 A에서 가장 많이 등장하는 숫자 반환
// 만약 두 가지 이상 있을 경우 아무것이나 반환
int majority1(const vector<int> &A) {
    int n = A.size();
    int majority = -1, majorityCount = 0;
    for (int i = 0; i < n; i++) {
        // A에 등장하는 A[i]의 수를 센다
        int V = A[i], count = 0;
        for (int j = 0; j < n; j++) {
            if (A[j] == V) count++;
        }
        if (count > majorityCount) {
            majorityCount = count;
            majority = V;
        }
    }
    return majority;
}