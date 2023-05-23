#include <bits/stdc++.h>

using namespace std;

vector<int> v;

int N, k;

bool comp(int a, int b){
    return a > b;
}

int main()
{
    cin >> N >> k;

    for(int i = 0; i < N; i++)
    {
        int x;
        cin >> x;
        v.push_back(x);
    }

    sort(v.begin(), v.end(), comp);

    cout << v[k-1];
    return 0;
}
