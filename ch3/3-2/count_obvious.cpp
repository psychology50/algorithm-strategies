#include <iostream>

using namespace std;

// [1, n] 범위의 자연수 x에 대해 x*1.0/x == 1인 x의 수를 센다
int countObvious(int n) {
    int same = 0;
    for(int x=1; x<=n; ++x) {
        double y = 1.0 / x;
        if (y * x == 1.0)
            ++same;
    }
    return same;
}

bool absoluteEqual(double a, double b) {
    return fabs(a-b) < 1e-10;
}

// a와 b의 상대 오차가 1e-8 이하이면 같은 수로 취급한다
bool relativeEqual(double a, double b) {
    return fabs(a-b) <= 1e-8 * max(fabs(a), fabs(b));
}

bool doubleEqual(double a, double b) {
    double diff = fabs(a-b);
    // 절대 오차가 허용 범위 안일 경우 무조건 true, 아니라면 상대 오차를 검사한다
    return (diff < 1e-10) ? true : (diff <= 1e-8 * max(fabs(a), fabs(b)));
}