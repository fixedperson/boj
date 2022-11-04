#include <iostream>

using namespace std;

int main() {
    int x = 0, y = 0, maxNum = -1;

    for(int i = 1; i <= 9; i++){
        for(int j = 1; j <= 9; j++){
            int temp;
            cin >> temp;
            if(temp > maxNum){
                x = i;
                y = j;
                maxNum = temp;
            }
        }
    }
    cout << maxNum << "\n" << x << " " << y;
    return 0;
}
