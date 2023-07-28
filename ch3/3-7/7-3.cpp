#include <iostream>
#include <vector>

using namespace std;

// 코드 7.3 두 큰 수를 곱하는 O(n^2) 시간 알고리즘

// num[]의 자릿수 올림을 처리한다
void normalize(vector<int>& num) {
    num.push_back(0);

    // 자릿수 올림을 처리한다
    for (int i = 0; i < num.size(); i++) {
        if (num[i] < 0) {
            int borrow = (abs(num[i]) + 9) / 10;
            num[i + 1] -= borrow;
            num[i] += borrow * 10;
        } else {
            num[i + 1] += num[i] / 10;
            num[i] %= 10;
        }
    }

    while (num.size() > 1 && num.back() == 0) num.pop_back();
}
// 두 긴 자연수의 곱을 반환한다
// 각 배열에는 각 수의 자릿수가 1의 자리에서부터 시작해 저장되어 있다