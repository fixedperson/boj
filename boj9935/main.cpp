#include <bits/stdc++.h>

using namespace std;

stack<char> st;

string s;
string bomb;

void explode() {
    string tmp = "";

    for(int i = 0; i < bomb.length(); i++) {
        tmp += st.top();
        st.pop();
    }
    reverse(tmp.begin(), tmp.end());

    if(bomb.compare(tmp) != 0) {
        for(int i = 0; i < tmp.length(); i++) {
            st.push(tmp[i]);
        }
    }
}

int main()
{
    cin >> s;

    cin >> bomb;

    for(int i = 0; i < s.length(); i++) {
        st.push(s[i]);

        if(s[i] == bomb[bomb.length() - 1] && st.size() >= bomb.length()) {
            explode();
        }
    }

    string ans;
    while(!st.empty()) {
        ans += st.top();
        st.pop();
    }
    reverse(ans.begin(), ans.end());

    if(ans.compare("") == 0) {
        cout << "FRULA";
    }
    else {
        cout << ans;
    }
}
