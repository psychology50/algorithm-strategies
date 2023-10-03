#include <iostream>
#include <vector>

using namespace std;

// 코드 9.25 피보나치 수열의 특정 항을 구하는 동적 계획법 알고리즘

int fib(int n) {
    if (n <= 1) return n;
    int seq[3];
    seq[0] = 0;
    seq[1] = 1;
    for (int i = 2; i <= n; ++i)
        seq[i % 3] = (seq[(i - 1) % 3] + seq[(i - 2) % 3]) % 100000;
    return seq[n % 3];
}

