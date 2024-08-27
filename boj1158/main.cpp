#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N, K;

    cin >> N >> K;

    queue<int> q;
    for (int i = 1; i <= N; i++) {
        q.push(i);
    }

    int cur = 0;
    cout << '<';
    while(q.size() > 1) {
        if(++cur % K == 0) {
            cout << q.front() << ", ";
            q.pop();
        }

        else {
            q.push(q.front());
            q.pop();
        }
    }
    cout << q.front() << ">";
}
