#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int lis3(int), count(int);
int n;
int cacheLength[501], cacheCount[501], S[500];

// 코드 9.11 K번째 LIS 구하기: K번째 LIS 계산하기

// S[start]에서 시작하는 LIS 중 사전순으로 skip개 건너뛴 수열을
// lis에 저장한다.
void reconstruct(int start, int skip, vector<int>& lis) {
    // 1. S[start]는 항상 LIS에 포함된다.
    if (start != -1) lis.push_back(S[start]);
    // 2. 뒤에 올 수 있는 숫자들의 목록을 만든다.
    vector<pair<int, int> > followers;
    for (int next = start + 1; next < n; ++next)
        if ((start == -1 || S[start] < S[next]) && lis3(start) == lis3(next) + 1)
            followers.push_back(make_pair(S[next], next));
    sort(followers.begin(), followers.end());
    // 3. k번째 LIS의 다음 숫자를 찾는다.
    for (int i = 0; i < followers.size(); ++i) {
        // 이 숫자를 뒤에 이어서 만들 수 있는 LIS의 개수를 확인한다.
        int idx = followers[i].second;
        int cnt = count(idx);
        if (cnt <= skip)
            skip -= cnt;
        else {
            // 다음 숫자는 S[idx]임을 알았다.
            // 4. 재귀 호출을 통해
            reconstruct(idx, skip, lis);
            break;
        }
    }
}
