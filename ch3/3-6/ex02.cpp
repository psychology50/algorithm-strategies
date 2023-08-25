#include <iostream>

using namespace std;

int fibonacciRecursive(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;

    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

int fibonacciIterative(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;

    int prev = 0;
    int current = 1;
    int result = 0;

    for (int i = 2; i <= n; i++) {
        result = prev + current;
        prev = current;
        current = result;
    }

    return result;
}

int main() {
    int n = 10;
    int fibonacciResult = fibonacciIterative(n);
    std::cout << "Fibonacci(" << n << ") = " << fibonacciResult << std::endl;

    return 0;
}