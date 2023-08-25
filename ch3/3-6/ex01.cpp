#include <iostream>

using namespace std;

int factorialRecursive(int n) {
    return (n <= 1) ? 1 : n * factorialRecursive(n - 1);
}

int factorialIterative(int n) {
    int ret = 1;
    for (int i = 1; i <= n; i++) 
        ret *= i;
    return ret;
}