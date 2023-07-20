#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

// 테스트하고 싶은 함수
void mySort(vector<int> &array);
// 주어진 배열을 문자열로 바꿈
string toString(const vector<int> &array);

int main() {
    while (true) {
        int n = rand() % 100 + 1; // 임의의 입력 생성
        vector<int> input(n);

        for (int i = 0; i < n; ++i) input[i] = rand();

        // 두 개의 복제를 만들어서 하나는 정렬 함수, 하나는 표준 라이브러리로 정렬
        vector<int> mySorted = input;
        mySort(mySorted);
        vector<int> stdSorted = input;
        sort(stdSorted.begin(), stdSorted.end());

        if (mySorted != stdSorted) {
            cout << "Wrong Answer: " << endl;
            cout << "Input: " << toString(input) << endl;
            cout << "My Answer: " << toString(mySorted) << endl;
            cout << "Standard Answer: " << toString(stdSorted) << endl;
            break;
        }
    }
}