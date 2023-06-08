#include <bits/stdc++.h>

using namespace std;

int main() {
    string N;
    cin >> N;

    bool zero = false;
    int sum = 0;
    vector<int> v;
    for(int i = 0; i < N.size(); i++){
        int temp = N[i] - '0';

        if(temp == 0) zero = true;
        sum += temp;
        v.push_back(temp);
    }
    sort(v.begin(), v.end());

    string ans = "";
    if(zero && sum % 3 == 0){
        for(int i = v.size()-1; i >= 0; i--){
            ans += to_string(v[i]);
        }
    }
    else {
        ans += "-1";
    }

    cout << ans;

    return 0;
}
