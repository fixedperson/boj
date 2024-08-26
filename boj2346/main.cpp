#include <bits/stdc++.h>

using namespace std;

int main()
{
    std::pmr::deque<pair<int, int>> dq;

    int N;
    cin >> N;

    for(int i = 1; i <= N; i++) {
        int num;
        cin >> num;

        dq.push_back({i, num});
    }

    while(!dq.empty()) {
        auto cur = dq.front();
        dq.pop_front();

        cout << cur.first << " ";
        int move = cur.second;

        if(move > 0) {
            for(int i = 0; i < move - 1; i++) {
                dq.push_back(dq.front());
                dq.pop_front();
            }
        }

        else {
            for(int i = 0; i > move; i--) {
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
    }
}
