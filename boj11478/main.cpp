#include <bits/stdc++.h>

using namespace std;

set <string> s;

int main() {
    string a;

    cin >> a;

    for(int i = 0; i < a.length(); i++){
        for(int j = 1; j <= a.length()-i; j++){
            s.insert(a.substr(i, j));
        }
    }

    cout << s.size();

    return 0;
}
