#include <iostream>

using namespace std;



int lcm(int a, int b) {
    return a * (b / gcd(a, b));
}