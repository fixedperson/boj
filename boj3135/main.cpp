#include <bits/stdc++.h>

using namespace std;

int main() {
    int A, B;
    cin >> A >> B;

    int N;
    cin >> N;

    int min = abs(B - A);
    for(int i = 0; i < N; i++){
        int num;
        cin >> num;

        if(min > abs(B - num)){
            min = abs(B - num);
        }
    }

    if(min == abs(B - A)) cout << min;
    else cout << min + 1;

    return 0;
}
