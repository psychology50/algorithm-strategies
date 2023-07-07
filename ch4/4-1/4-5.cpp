#include <iostream>
#include <vector>

using namespace std;

const int INF = 987654321;

// 이 메뉴로 모두가 식사할 수 있는지 여부를 반환한다.
bool canEverybodyEat(const vector<int> &menu) {
    // 각 친구들이 주어진 메뉴를 먹을 수 있는지 여부를 담은 배열을 만든다.
    vector<bool> edible(menu.size(), false);
    for (int i = 0; i < edible.size(); ++i)
        for (int j = 0; j < menu.size(); ++j)
            if (menu[j] <= i + 1)
                edible[i] = !edible[i - menu[j]];

    return edible.back();
}

int M;
// food 번째 음식을 만들 지 여부를 결정
int selectMenu(vector<int> &menu, int food) {
    // 기저 사례: 모든 음식에 대해 만들지 여부를 결정했을 때
    if (food == menu.size()) {
        if (canEverybodyEat(menu))
            return menu.size();
        return INF; // 아무것도 못 먹는 사람이 있는 경우
    }

    // 이 음식을 만들지 않을 경우
    int ret = selectMenu(menu, food + 1);
    // 이 음식을 만드는 경우의 답을 계산해서 더 작은 것을 취한다.
    ret = min(ret, selectMenu(menu, food + 1));
    menu.push_back(food);
    ret = min(ret, selectMenu(menu, food + 1));
    menu.pop_back();
    return ret;
}