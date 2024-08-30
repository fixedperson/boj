#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N;
    cin>>N;

    stack<int> st;
    for(int i = 0; i < N; i++) {
        int x;
        cin>>x;

        st.push(x);
    }

    int max = st.top();
    st.pop();
    int answer = 1;
    while(!st.empty()) {
        int x = st.top();
        st.pop();
        if(x > max) {
            answer++;
            max = x;
        }
    }

    cout << answer;
}
