#include <iostream>
#include <vector>
#include <cmath>

#define MAX_SIZE 1024

using namespace std;

// 코드 7.5 쿼드 트리 압축을 해제하는 재귀 호출 알고리즘

char decompressed[MAX_SIZE][MAX_SIZE];
void decompress(string::iterator& it, int y, int x, int size) {
    // 한 글자를 검사할 때마다 반복자를 한 칸 앞으로 옮긴다
    char head = *(it++);
    // 기저 사례: 첫 글자가 b 또는 w인 경우
    if (head == 'b' || head == 'w') {
        for (int dy = 0; dy < size; dy++) 
            for (int dx = 0; dx < size; dx++) 
                decompressed[y + dy][x + dx] = head;
    } else {
        int half = size / 2;
        // 네 부분을 각각 순서대로 압축 해제한다
        decompress(it, y, x, half);
        decompress(it, y, x + half, half);
        decompress(it, y + half, x, half);
        decompress(it, y + half, x + half, half);
    }
}