#include <iostream>
#include <vector>

using namespace std;

// 코드 9.12 드래곤 커브 문자열을 생성하는 재귀 호출 알고리즘

// 초기 문자열 seed를 generations 세대 진화한 결과 반환
void curve(const string& seed, int generations) {
    // 기저 사례
    if (generations == 0) {
        cout << seed;
        return;
    }
    for (int i = 0; i < seed.size(); ++i)
        if (seed[i] == 'X')
            curve("X+YF", generations - 1);
        else if (seed[i] == 'Y')
            curve("FX-Y", generations - 1);
        else
            cout << seed[i];
}
