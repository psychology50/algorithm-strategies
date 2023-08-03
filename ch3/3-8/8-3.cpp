#include <iostream>
#include <vector>

using namespace std;

// 코드 8.3 메모이제이션의 사용 예

// 전부 -1로 초기화해 둔다
int cache[2500][2500];
// a와 b는 각각 [0, 2500) 구간 안의 정수
// 반환 값은 항상 int형 안에 들어가는 음이 아닌 정수
int someObscureFunction(int a, int b) {
    // 기저 사례를 처음으로 만났을 때 반환한다
    if (a == b) return a;
    // (a, b)에 대한 답을 구한 적이 있으면 곧장 반환
    int& ret = cache[a][b];
    if (ret != -1) return ret;
    // 여기에서 답을 계산한다
    ret = someObscureFunction(a + 1, b) + someObscureFunction(a, b - 1);
    return ret;
}

int main() {
    // memset()을 이용해 cache 배열을 초기화한다.
    memset(cache, -1, sizeof(cache));
}