#include <iostream>

using namespace std;

int gcd(int a, int b); // 두 수의 최대공약수 반환

// 1. 더 큰 자료형 사용하기
// int lcm(int a, int b) {
//     return (a * (long long)b) / gcd(a, b);
// }

// 2. 연산 순서 바꾸기
int lcm(int a, int b) {
    return a * (b / gcd(a, b));
}