#include <iostream>

using namespace std;

int gcd(int a, int b); // 두 수의 최대공약수 반환

int lcm(int a, int b) {
    return a * b / gcd(a, b);
}