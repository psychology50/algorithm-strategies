#include <algorithm>
#include <iostream>

using namespace std;

class IntegerSet {
    private:
        int size;
        int *arr;
    public:
        IntegerSet(int size) {
            this->size = size;
            arr = new int[size];
        }
        ~IntegerSet() {
            delete[] arr;
        }
        friend bool operator < (const IntegerSet &a, const IntegerSet &b);
};

// a가 b의 진부분 집합이면 true, 아니면 false
bool isProperSubset(const IntegerSet &a, const IntegerSet &b);
// a가 b의 진부분 집합일 때 a가 항상 앞에 오도록 집합 정렬
// bool operator < (const IntegerSet &a, const IntegerSet &b) {
//     // a가 b의 진부분 집합이면 a가 앞으로
//     if (isProperSubset(a, b)) return true;
//     // b가 a의 진부분 집합이면 b가 앞으로
//     if (isProperSubset(b, a)) return false;
//     // a, b 둘 다 꼭 앞으로 올 필요 없다.
//     return false;
// }

bool operator < (const IntegerSet &a, const IntegerSet &b) {
    // a가 b의 진부분 집합이면 a가 앞으로
    if (isProperSubset(a, b)) return true;
    // b가 a의 진부분 집합이면 b가 앞으로
    if (isProperSubset(b, a)) return false;
    // a, b 크기가 다르다면 작은 쪽이 앞으로
    if (a.size() != b.size()) return a.size() < b.size();
    // a, b 사전순으로 비교해 반환
    return lexicographical_compare(a.begin(), a.end(), b.begin(), b.end());
}