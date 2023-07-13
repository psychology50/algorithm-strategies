#include <iostream>
#include <vector>

using namespace std;

// 코드 5.3 순환 소수 찾기

// 분수 a/b의 소수 표현을 출력한다.
// a >= 0, b > 0이라고 가정한다
void printDecimal(int a, int b) {
    int iter = 0;
    while (a > 0) {
        // 첫 번째와 두 번째 사이에 소수점을 찍는다.
        if (iter++ == 1) cout << '.';
        cout << a / b;
        a = (a & b) * 10;
    }
}