#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

// 코드 9.14 드래곤 커브 문제를 해결하는 알고리즘

const int MAX = 1000000000 + 1;
// length[i] = X나 Y를 i번 치환한 후의 길이
int length[51];
void precalc() {
    length[0] = 1;
    for (int i = 1; i <= 50; ++i)
        length[i] = min(MAX, length[i - 1] * 2 + 2);
}
const string EXPAND_X = "X+YF";
const string EXPAND_Y = "FX-Y";

// dragonCurve를 generations 진화시킨 결과에서 skip번째 문자를 반환한다.
char expand(const string& dragonCurve, int generations, int skip) {
    // 기저 사례
    if (generations == 0) {
        assert(skip < dragonCurve.size());
        return dragonCurve[skip];
    }
    for (int i = 0; i < dragonCurve.size(); ++i) {
        // 문자열이 확장되는 경우
        if (dragonCurve[i] == 'X' || dragonCurve[i] == 'Y') {
            if (skip >= length[generations])
                skip -= length[generations];
            else if (dragonCurve[i] == 'X')
                return expand(EXPAND_X, generations - 1, skip);
            else
                return expand(EXPAND_Y, generations - 1, skip);
        }
        // 확장되지 않는 경우
        else if (skip > 0) --skip;
        else return dragonCurve[i];
    }
    return '#'; // 이 줄은 실행되지 않는다.
}
