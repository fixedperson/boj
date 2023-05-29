#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(false), cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> v;
    for(int i = 0; i < N; i++){
        int num;
        cin >> num;
        v.push_back(num);
    }

    int cnt = 0;
    int prev = 0;
    for(auto num : v){
        if(prev <= num) cnt++;

        prev = num;
    }

    cout << cnt;
    return 0;
}
