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

    public:
    SequreMatrix pow(int n) const {
        SequreMatrix ret(size);
        if (n == 0) {
            for (int i = 0; i < size; ++i)
                ret[i][i] = 1;
            return ret;
        }
        if (n % 2 == 1)
            return pow(n - 1) * (*this);
        SequreMatrix half = pow(n / 2);
        return half * half;
    }
};

// 코드 9.31 지니어스 문제를 해결하는 행렬의 거듭제곱 동적 계획법

int n, k, length[50];
double T[50][50];

// k분 30초 후에 각 곡이 재생되고 있을 확률을 반환한다.
vector<double> getProb2() {
    SequreMatrix W(4*n);
    // 첫 3*n개의 원소는 그대로 복사해온다.
    for (int i = 0; i < 3*n; ++i)
        W[i][i+n] = 1.0;
    // 마지막 n개의 원소는 이전 원소들의 선형 결합으로 이루어진다.
    for (int i = 0; i < n; ++i)
        // C[time+1][i] = C[time+1-length[j]][j] * T[j][i]
        for (int j = 0; j < n; ++j) 
            W[3*n+i][(4-length[j])*n+j] = T[j][i];
    SequreMatrix Wk = W.pow(k);
    vector<double> ret(n);
    // song번 노래가 재생되고 있을 확률을 계산한다.
    for (int song = 0; song < n; ++song) 
        // song번 노래가 시작할 확률을 모두 찾아 더한다.
        for (int start = 0; start < length[song]; ++start)
            ret[song] += Wk[(3-start)*n+song][3*n];
    return ret;
}

