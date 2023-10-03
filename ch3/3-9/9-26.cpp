#include <iostream>
#include <vector>

using namespace std;

// SequreMatrix: 정사각 행렬을 표현하는 자료구조
struct SequreMatrix {
    int size;
    vector<vector<int> > matrix;
    SequreMatrix(int n) : size(n) {
        matrix.resize(size, vector<int>(size, 0));
    }
    SequreMatrix operator*(const SequreMatrix& other) const {
        SequreMatrix ret(size);
        for (int i = 0; i < size; ++i)
            for (int j = 0; j < size; ++j) {
                long long sum = 0;
                for (int k = 0; k < size; ++k)
                    sum += matrix[i][k] * other.matrix[k][j];
                ret.matrix[i][j] = sum % 100000;
            }
        return ret;
    }
    vector<int>& operator[](int i) {
        return matrix[i];
    }
};

// 코드 9.26 피보나치 수열의 특정 항을 구하는 빠른 행렬 제곱 알고리즘

// A^n을 구한다. 이때 각 계산은 모두 100,000으로 나눈 나머지를 취한다.
SequreMatrix pow(const SequreMatrix& A, int n);

int fib3(int n) {
    if (n == 0) return 0;
    SequreMatrix W(2);
    W[0][0] = 0;
    W[0][1] = W[1][0] = W[1][1] = 1;
    return pow(W, n - 1)[1][1];
}

