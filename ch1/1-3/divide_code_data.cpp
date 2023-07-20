#include <iostream>

using namespace std;

// 비효율적
string getMonthName(int month) {
    if (month == 1) return "January";
    else if (month == 2) return "February";
    else if (month == 3) return "March";
    else if (month == 4) return "April";
    else if (month == 5) return "May";
    else if (month == 6) return "June";
    else if (month == 7) return "July";
    else if (month == 8) return "August";
    else if (month == 9) return "September";
    else if (month == 10) return "October";
    else if (month == 11) return "November";
    else if (month == 12) return "December";
    else return "Invalid month";
}

// 효율적
const string monthNmae[] = {
    "January", "February", "March", "April", "May", "June", "July", "August",
    "September", "October", "November","December"
};

const int dx[] = {0, 1, 0, -1};
const int dy[] = {-1, 0, 1, 0};