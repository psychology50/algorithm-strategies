#include <iostream>
#include <vector>

using namespace std;

bool canCover(double mid);

// double minRaiusCover() {
//     double minRadius = 0, maxRadius = 0;

//     // 반복문 불변식 : canCover(maxRadius) = true
//     while (maxRadius - minRadius > 1e-10) {
//         double mid = (minRadius + maxRadius) / 2;
//         if (canCover(mid))
//             maxRadius = mid;
//         else
//             minRadius = mid;
//     }
//     return maxRadius;
// }

// candiates는 오름차순 정렬되어 있고, 마지막 원소는 항상 10이라 가정
double minRaiusCover(const vector<double> &candidates) {
    int minIndex = -1, maxIndex = candidates.size() - 1;

    // 반복문 불변식 : canCover(maxRadius) = true
    while (minIndex + 1 < maxIndex) {
        double mid = (minIndex + maxIndex) / 2;
        if (canCover(mid))
            maxIndex = mid;
        else
            minIndex = mid;
    }
    return candidates[maxIndex];
}