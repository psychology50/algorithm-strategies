#include <iostream>
#include <vector>

using namespace std;

// 코드 9.2 코드
int n, capacity;
int volume[100], need[100];
int cache[1001][100];
string name[100];
int pack(int, int);

// 코드 9.3 여행 짐 싸기 문제의 답 역추적하는 재귀 호출 알고리즘

// pack(capacity, item)이 선택한 물건들의 목록을 picked에 저장한다.
void reconstruct(int capacity, int item, vector<string>& picked) {
    // 기저 사례: 모든 물건을 다 고려했음
    if (item == n) return;
    if (pack(capacity, item) == pack(capacity, item + 1)) {
        reconstruct(capacity, item + 1, picked);
    } else {
        picked.push_back(name[item]);
        reconstruct(capacity - volume[item], item + 1, picked);
    }
}