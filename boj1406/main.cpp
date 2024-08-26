#include <bits/stdc++.h>

using namespace std;

int main()
{
    string s;
    cin >> s;

    list <char> l(s.begin(), s.end());

    int M;
    cin >> M;

    auto it = l.end();
    while(M -- > 0) {
        char cmd;
        cin >> cmd;

        if(cmd == 'L') {
            if(it != l.begin()) {
                it--;
            }
        }

        else if(cmd == 'D') {
            if(it != l.end()) {
                it++;
            }
        }

        else if(cmd == 'B') {
            if(it != l.begin()) {
                it--;
                it = l.erase(it);
            }
        }

        else if(cmd == 'P') {
            char c;
            cin >> c;

            l.insert(it, c);
        }
    }

    for(it = l.begin(); it != l.end(); it++) {
        cout << *it;
    }
    return 0;
}
