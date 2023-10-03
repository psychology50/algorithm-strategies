#include <iostream>
#include <vector>

using namespace std;

// 코드 9.16 웨브바짐 문제를 해결하는 완전 탐색 알고리즘

// digits: e의 자릿수들을 정렬한 것
string e, digits;
int n, m;
// e의 자릿수로 만들 수 있는 숫자들을 모두 출력한다.
// price: 지금까지 만든 가격
// taken: digits의 각 자릿수의 사용 여부
void generate(string price, bool taken[15]) {
    // 기저 사례: price의 자릿수가 e의 자릿수와 같을 때
    if (price.size() == n) {
        if (price < e) 
            cout << price << endl;
        return;
    }
    // 아직 사용하지 않은 자릿수를 찾는다.
    for (int i = 0; i < digits.size(); ++i)
        if (!taken[i] && (i == 0 || digits[i - 1] != digits[i] || taken[i - 1])) {
            taken[i] = true;
            generate(price + digits[i], taken);
            taken[i] = false;
        }
}

