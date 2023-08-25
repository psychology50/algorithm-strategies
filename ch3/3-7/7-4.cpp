#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

// 코드 7.4 카라츠바의 빠른 정수 곱셈 알고리즘

// a += b * (10^k)를 구현한다
void addTo(vector<int>& a, const vector<int>& b, int k) {
    int length = b.size();
    a.resize(max(a.size() + 1, b.size() + k));
    for (int i = 0; i < length; i++) 
        a[i + k] += b[i];
    normalize(a); // 정규화
}

// a -= b; 를 구현한다. a >= b를 가정한다
void subFrom(vector<int>& a, const vector<int>& b) {
    int length = b.size();
    a.resize(max(a.size() + 1, b.size()) + 1);
    for (int i = 0; i < length; i++) 
        a[i] -= b[i];
    normalize(a);
}

// 두 긴 정수의 곱을 반환한다
vector<int> karatsuba(const vector<int>& a, const vector<int>& b) {
    int an = a.size(), bn = b.size();

    // a가 b보다 짧을 경우 둘을 바꾼다
    if (an < bn) return karatsuba(b, a);
    // 기저 사례: a나 b가 비어 있는 경우
    if (an == 0 || bn == 0) return vector<int>();
    // 기저 사례: a가 비교적 짧은 경우 O(n^2) 곱셈으로 변경한다
    if (an <= 50) return multiply(a, b);

    int half = an / 2;
    // a와 b를 밑에서 half 자리와 나머지로 분리한다
    vector<int> a0(a.begin(), a.begin() + half);
    vector<int> a1(a.begin() + half, a.end());
    vector<int> b0(b.begin(), b.begin() + min<int>(b.size(), half));
    vector<int> b1(b.begin() + min<int>(b.size(), half), b.end());

    // z2 = a1 * b1
    vector<int> z2 = karatsuba(a1, b1);
    // z0 = a0 * b0
    vector<int> z0 = karatsuba(a0, b0);
    // a0 = a0 + a1; b0 = b0 + b1
    addTo(a0, a1, 0); addTo(b0, b1, 0);
    // z1 = (a0 * b0) - z0 - z2;
    vector<int> z1 = karatsuba(a0, b0);
    subFrom(z1, z0);
    subFrom(z1, z2);
    // ret = z0 + z1 * 10^half + z2 * 10^(half*2)
    vector<int> ret;
    addTo(ret, z0, 0); addTo(ret, z1, half); addTo(ret, z2, half + half);
    return ret;
}