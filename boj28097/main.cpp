#include <bits/stdc++.h>

using namespace std;

int main() {
    int N;
    cin >> N;

    int sum = 0;
    for(int i = 0; i < N; i++){
        int num;
        cin >> num;
        sum += num;
    }

    sum += 8 * (N-1);

    cout << sum / 24 << " " << sum % 24;
    return 0;
}
