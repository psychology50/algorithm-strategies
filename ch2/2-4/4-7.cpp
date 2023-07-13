#include <iostream>
#include <vector>

using namespace std;

// array[i] = element인 첫 i를 반환. 없으면 -1
int firstIndex(const vector<int> &array, int element) {
    for (int i = 0; i < array.size(); ++i)
        if (array[i] == element)
            return i;
    return -1;
}