#include <iostream>
#include <vector>

using namespace std;

// 자연수 n의 소인수 분해 결과를 담은 정수 배열을 반환한다
vector<int> factor(int n) {
    if (n==1) return vector<int>(1, 1); // n=1인 경우 예외 처리
    vector<int> ret;
    // 가장 작은 소인수부터 시작해 한 번에 하나씩 추가한다
    for (int div = 2; n > 1; ++div) {
        while (n % div == 0) {
            n /= div;
            ret.push_back(div);
        }
    }
    return ret;
}