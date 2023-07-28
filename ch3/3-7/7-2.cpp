#include <iostream>
#include <vector>

using namespace std;

// 코드 7.2 행렬의 거듭제곱을 구하는 분할 정복 알고리즘

// 정방행렬을 표현하는 SquareMatrix 클래스
class SquareMatrix {
private:
    // 행렬의 크기
    int n;
    // 행렬의 값
    vector<vector<double>> v;
public:
    // 생성자와 소멸자
    SquareMatrix(int n) : n(n), v(n, vector<double>(n, 0)) {}
    SquareMatrix(int n, const vector<double>& v) : n(n), v(n, vector<double>(n, 0)) {
        for (int i = 0; i < n; i++) 
            this->v[i][i] = v[i];
    }
    SquareMatrix(int n, const vector<vector<double>>& v) : n(n), v(v) {}

    // 행렬의 곱셈
    SquareMatrix operator*(const SquareMatrix& other) {
        SquareMatrix ret(n);
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                for (int k = 0; k < n; k++) 
                    ret.v[i][j] += this->v[i][k] * other.v[k][j];
        return ret;
    }

    // 행렬의 거듭제곱
    SquareMatrix pow(int m) {
        // 기저 사례: A^0 = I
        if (m == 0) return SquareMatrix(n, vector<vector<double>>(n, vector<double>(n, 1)));
        if (m % 2 > 0) return pow(m - 1) * (*this);
        SquareMatrix half = pow(m / 2);
        return half * half;
    }

    // 행렬의 크기를 반환한다
    int size() const { return n; }
};

// n*n 크기의 항등 행렬(identity matrix)을 반환하는 함수
SquareMatrix identity(int n) {
    SquareMatrix ret(n, vector<double>(n, 0));
    for (int i = 0; i < n; i++)
        ret[i][i] = 1;
    return ret;
}

// A^m을 반환한다
SquareMatrix pow(const SquareMatrix& A, int m) {
    // 기저 사례: A^0 = I
    if (m == 0) return identity(A.size());
    if (m % 2 > 0) return pow(A, m - 1) * A;
    SquareMatrix half = pow(A, m / 2);
    return half * half;
}