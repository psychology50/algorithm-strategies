#include <iostream>
#include <vector>

using namespace std;

// 코드 9.2 여행 짐 싸기 문제를 해결하는 동적 계획법 알고리즘

int n, capacity;
int volume[100], need[100];
int cache[1001][100];
string name[100];
// 캐리어에 남은 용량이 capacity일 때, item 이후의 물건들을
// 담아 얻을 수 있는 최대 절박도의 합을 반환한다.
int pack(int capacity, int item) {
    // 기저 사례: 더 담을 물건이 없을 때
    if (item == n) return 0;
    int& ret = cache[capacity][item];
    if (ret != -1) return ret;
    // 이 물건을 담지 않을 경우
    ret = pack(capacity, item + 1);
    // 이 물건을 담을 경우
    if (capacity >= volume[item])
        ret = max(ret, pack(capacity - volume[item], item + 1) + need[item]);
    return ret;
}
