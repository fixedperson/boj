#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N;
    cin >> N;

    queue<int> q;
    while(N -- > 0) {
        string s;
        cin >> s;

        if(s.compare("push") == 0) {
            int X;
            cin >> X;

            q.push(X);
        }

        else if(s.compare("pop") == 0) {
            if(q.empty()) cout << "-1" << "\n";
            else {
                cout << q.front() << "\n";
                q.pop();
            }
        }

        else if(s.compare("size") == 0) {
            cout << q.size() << "\n";
        }

        else if(s.compare("empty") == 0) {
            if(q.empty()) cout << "1\n";
            else cout << "0\n";
        }

        else if(s.compare("front") == 0) {
            if(q.empty()) cout << "-1\n";
            else cout << q.front() << "\n";
        }

        else if(s.compare("back") == 0) {
            if(q.empty()) cout << "-1\n";
            else cout << q.back() << "\n";
        }
    }
}
