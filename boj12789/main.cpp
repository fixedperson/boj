#include <bits/stdc++.h>

using namespace std;

int main()
{
    stack<int> st;

    int n;
    cin >> n;
    st.push(n+1);

    int cur = 1;
    for (int i = 0; i < n; i++) {
        while (st.top() == cur) {
            cur++;
            st.pop();
        }

        int num;
        cin >> num;

        if(num == cur) {
            cur++;
            continue;
        }

        if(st.top() > num) {
            st.push(num);
        }

        else {
            cout << "Sad";
            return 0;
        }
    }

    cout << "Nice";
}
