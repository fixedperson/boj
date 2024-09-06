#include <bits/stdc++.h>

using namespace std;

vector<int> v;

int main()
{
    int N;
    cin >> N;

    long long answer = 0;

    int h;
    cin >> h;
    v.push_back(h);
    while(N-- > 1) {
        cin >> h;

        while(!v.empty() && v.back() <= h) {
            v.pop_back();
        }

        answer += v.size();
        v.push_back(h);
    }

    cout << answer;
}
