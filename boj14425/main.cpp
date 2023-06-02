#include <bits/stdc++.h>

using namespace std;

int N, M;
set<string> set1;

int main()
{
    cin >> N >> M;
    while(N--)
    {
        string s;
        cin >> s;

        set1.insert(s);
    }

    int cnt = 0;
    while(M--)
    {
        string s;
        cin >> s;

        if(set1.find(s) != set1.end()) cnt++;
    }

    cout << cnt;
    return 0;
}
