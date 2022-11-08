#include <bits/stdc++.h>

using namespace std;

int main() {

    int N;

    cin >> N;
    cin.ignore();

    while(N-- > 0){
        string s;

        getline(cin, s);
        s[0] = toupper(s[0]);
        cout << s << "\n";
    }

    return 0;
}
