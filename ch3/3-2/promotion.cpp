#include <iostream>
#include <vector>

using namespace std;

bool isSorted(const vector<int> &seq) {
    for (int i=0; i<seq.size()-1; ++i)
        if (seq[i] > seq[i+1])
            return false;
    return true;
}

int main() {
    unsigned char a = 17;
    short b = -18;
    int c = 2;
    unsigned int d = 0;
    cout << (a + b) * c + d << endl;
}