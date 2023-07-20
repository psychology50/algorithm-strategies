#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;

    for (int i = 0; i < n; i++)
        for (int j = i+1; j < n; j++)
            for (int k = j+1; k < n; k++)
                for (int l = k+1; l < n; l++)
                    cout << i << " " << j << " " << k << " " << l << endl;
}