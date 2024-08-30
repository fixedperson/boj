#include <bits/stdc++.h>

using namespace std;

stack<char> st;

void fail() {
    cout << "0";
    exit(0);
}

int main()
{
    string s;
    cin>>s;

    int answer = 0;
    int temp = 1;
    for (int i = 0; i < s.length(); i++) {
        if(s[i] == '(') {
            temp *= 2;
            st.push(s[i]);
        }

        else if(s[i] == '[') {
            temp *= 3;
            st.push(s[i]);
        }

        else if(s[i] == ')') {
            if(st.empty() || st.top() != '(') {
                fail();
            }

            if(s[i-1] == '(') {
                answer += temp;
            }

            st.pop();
            temp /= 2;
        }

        else  {
            if(st.empty() || st.top() != '[') {
                fail();
            }

            if(s[i-1] == '[') {
                answer += temp;
            }

            st.pop();
            temp /= 3;
        }
    }

    if(!st.empty()) fail();

    cout << answer;
}
