#include <bits/stdc++.h>

using namespace std;

int N, M;
vector<string> v;
map<string, int> mp;

bool compare(string a, string b){
    if(mp[a] == mp[b])
    {
        if(a.size() == b.size())
        {
            return a < b;
        }
        return a.size() > b.size();
    }
    return mp[a] > mp[b];
}

int main()
{
    cin >> N >> M;

    for(int i = 0; i < N; i++)
    {
        string s;
        cin >> s;
        if(s.size() < M) continue;

        if(mp.find(s) == mp.end())
        {
            mp[s] = 1;
            v.push_back(s);
        }

        else
        {
            mp[s]++;
        }
    }

    sort(v.begin(), v.end(), compare);

    for(int i = 0; i < v.size(); i++)
    {
        cout << v[i] << '\n';
    }

    return 0;
}
