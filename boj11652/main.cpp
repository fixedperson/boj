#include <bits/stdc++.h>

using namespace std;

map<long long, int> mp;

bool cmp(const pair<long long, int>& p1, const pair<long long, int>& p2) {
    if(p1.second == p2.second) {
        return p1.first < p2.first;
    }
    return p1.second > p2.second;
}

int main()
{
    int N;

    cin >> N;

    for(int i = 0; i < N; i++) {
        long long s;
        cin >> s;

        if(mp.find(s) == mp.end()) {
            mp.insert(pair<long long, int>(s, 1));
        }

        else {
            mp[s]++;
        }
    }

    vector<pair<long long, int>> v(mp.begin(), mp.end());
    sort(v.begin(), v.end(), cmp);

    cout << v[0].first;
}
