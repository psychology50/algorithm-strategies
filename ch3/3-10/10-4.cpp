#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// 코드 10.4 문자열 합치기 문제를 해결하는 탐욕적 알고리즘

// 문자열들의 길이가 주어질 때 하나로 합치는 최소 비용을 반환한다.
int concat(const vector<int>& lengths) {
    // 비교 함수를 greater<>로 선언해 최소 힙을 만든다
    priority_queue<int, vector<int>, greater<int> > pq;
    for (int i = 0; i < lengths.size(); ++i)
        pq.push(lengths[i]);

    int ret = 0;
    // 힙에 원소가 하나만 남을 때까지
    while (pq.size() > 1) {
        // 가장 짧은 문자열 두 개를 찾아서 합치고 큐에 넣는다
        int min1 = pq.top(); pq.pop();
        int min2 = pq.top(); pq.pop();
        pq.push(min1 + min2);
        ret += min1 + min2;
    }
    return ret;
}