#include <iostream>

using namespace std;

// // 모든 짝수는 소수가 아니다?
// bool isPrime(int n) {
//     if (n % 2 == 0) return false;
//     for (int i=2; i<n; ++i)
//         if (n % i == 0)
//             return false;
//     return true;
// }

// 소수가 아니면서 가장 작은 자연수 1도 문제
bool isPrime(int n) {
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    for (int i=2; i<n; ++i)
        if (n % i == 0)
            return false;
    return true;
}
