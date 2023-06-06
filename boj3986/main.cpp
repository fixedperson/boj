#include <bits/stdc++.h>

using namespace std;

int main() {
    int N;
    cin >> N;

    int answer = 0;
    for(int i = 0; i < N; i++){
        string s;
        cin >> s;

        stack<char> st;
        for(int j = 0; j < s.size(); j++){
            if(!st.empty() && st.top() == s[j]) st.pop();
            else st.push(s[j]);
        }

        if(st.size() == 0) answer++;
    }

    cout << answer;
    return 0;
}
