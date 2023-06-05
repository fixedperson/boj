#include <bits/stdc++.h>

using namespace std;

int main() {
    int N, A, B;

    cin >> N >> A >> B;

    if(N <= B) {
        if(A < B) cout << "Bus";
        else if(A > B) cout << "Subway";
        else cout << "Anything";
    }

    else {
        cout << "Bus";
    }
    return 0;
}
