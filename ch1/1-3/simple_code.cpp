#include <iostream>
#include <vector>

using namespace std;

bool hashDuplicate(const vector<int>& array) {
    for (int i=0; i<array.size(); ++i)
        for (int j=0; j<i; ++j)
            if (array[i] == array[j])
                return true;
    return false;
}

#define FOR(i,n) for(int i=0; i<n; ++i)
bool hashDuplicateMacro(const vector<int>& array) {
    FOR(i,array.size())
        FOR(j,i)
            if (array[i] == array[j])
                return true;
    return false;
}

int main() {
    vector<int> array = {1,2,3,4,5,6,7,8,9,10};
    cout << hashDuplicate(array) << endl;
    cout << hashDuplicateMacro(array) << endl;
}