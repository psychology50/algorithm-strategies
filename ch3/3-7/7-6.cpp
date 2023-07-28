#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// 코드 7.6 쿼드 트리 뒤집기 문제를 해결하는 분할 정복 알고리즘

string reverse(string::iterator& it) {
    char head = *(it++);
    if (head == 'b' || head == 'w') return string(1, head);
    string upperLeft = reverse(it);
    string upperRight = reverse(it);
    string lowerLeft = reverse(it);
    string lowerRight = reverse(it);
    // 각각의 네 부분을 반대로 잘 합친다
    return string("x") + lowerLeft + lowerRight + upperLeft + upperRight;
}