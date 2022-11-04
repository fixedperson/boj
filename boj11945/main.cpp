#include <bits/stdc++.h>

using namespace std;


int main() {

    int N, M;

    cin >> N >> M;

    vector<string> vec;

    for(int i = 0; i < N; i++){
        string s;
        cin >> s;
        vec.push_back(s);
    }

    for(int i = 0; i < N; i++){
        reverse(vec[i].begin(), vec[i].end());
        cout << vec[i] << "\n";
    }

    return 0;
}
