#include <bits/stdc++.h>

using namespace std;

int main() {
    int N;

    cin >> N;

    vector<string> vec;

    string s;

    getline(cin, s);

    for(int i = 0; i < N; i++){
        getline(cin, s);
        vec.push_back(s);
    }

    for(int i = 1; i <= N; i++){
        cout << i << ". " << vec[i-1] << "\n";
    }

    return 0;
}
