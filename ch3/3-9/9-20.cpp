#include <iostream>
#include <vector>

using namespace std;

// 코드 9.20 틱택토를 해결하는 동적 계획법 알고리즘

// tum이 한 줄을 만들었는지를 반환한다.
bool isFinished(const vector<string>& board, char turn) {
    // 세로줄을 검사한다.
    for (int j = 0; j < 3; ++j)
        if (board[0][j] == turn && board[1][j] == turn && board[2][j] == turn)
            return true;
    // 가로줄을 검사한다.
    for (int i = 0; i < 3; ++i)
        if (board[i] == string(3, turn))
            return true;
    // 대각선을 검사한다.
    if (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn)
        return true;
    if (board[0][2] == turn && board[1][1] == turn && board[2][0] == turn)
        return true;
    return false;
}

// 틱택토 게임판이 주어질 때 [0..19682] 범위의 정수로 변환한다.
int bijection(const vector<string>& board) {
    int ret = 0;
    for (int y = 0; y < 3; ++y)
        for (int x = 0; x < 3; ++x) {
            ret *= 3;
            if (board[y][x] == 'o') ++ret;
            else if (board[y][x] == 'x') ret += 2;
        }
    return ret;
}

// cache[]는 -2로 초기화한다.
int cache[19683];
// 내가 이길 수 있으면 1을, 비길 수 있으면 0을, 지면 -1을 리턴한다.
int canWin(vector<string>& board, char turn) {
    // 기저 사례: 마지막에 상대가 둬서 한 줄이 만들어진 경우
    if (isFinished(board, 'o' + 'x' - turn))
        return -1;
    int& ret = cache[bijection(board)];
    if (ret != -2) return ret;
    // -2가 아닌 값이 들어가 있다는 것은 이전에 한 번 계산했다는 의미다.
    // 따라서 이전의 계산 결과를 재사용한다.
    // 모든 반환 값이 0 이상이므로 이것에 1을 더하면 1 이상의 값이 된다.
    int minValue = 2;
    for (int y = 0; y < 3; ++y)
        for (int x = 0; x < 3; ++x)
            if (board[y][x] == '.') {
                board[y][x] = turn;
                minValue = min(minValue, canWin(board, 'o' + 'x' - turn));
                board[y][x] = '.';
            }
    // 플레이할 수 없거나, 어떻게 해도 비기는 것이 최선인 경우
    if (minValue == 2 || minValue == 0) return ret = 0;
    // 최선이 상대가 이기는 거라면 난 무조건 지고, 상대가 지는 거라면 난 이긴다.
    return ret = -minValue;
}
