#include <bits/stdc++.h>

using namespace std;

bool comp(const pair<string, int> &s1, const pair<string, int> &s2) {
    return s1.first < s2.first;
}

int main()
{
    int N;
    cin >> N;

    unordered_map<string, int> mp;
    for(int i = 0; i < N; i++) {
        string s;
        cin >> s;
        string token;
        stringstream ss(s);
        while (getline(ss, token, '.')) {}

        if(mp.find(token) == mp.end()) {
            mp.insert(pair<string, int>(token, 1));
        }
        else {
            mp[token]++;
        }
    }

    vector<pair<string, int>> v(mp.begin(), mp.end());
    sort(v.begin(), v.end(), comp);

    for(int i = 0; i < v.size(); i++) {
        cout << v[i].first << " " << v[i].second << endl;
    }
}
