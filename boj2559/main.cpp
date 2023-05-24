#include <bits/stdc++.h>

using namespace std;

int main() {
    int N, K;

    cin >> N >> K;

    int arr[N];
    for(int i = 0; i < N; i++){
        cin >> arr[i];
    }

    int cur = 0;
    int sum = 0;
    int max_sum = 0;
    for(int i = cur; i < cur + K; i++){
        sum += arr[i];
    }
    max_sum = sum;

    while(true){
        if(cur + K >= N) break;

        sum -= arr[cur];
        sum += arr[cur + K];
        if(sum > max_sum) max_sum = sum;

        cur++;
    }

    cout << max_sum;
    return 0;
}
