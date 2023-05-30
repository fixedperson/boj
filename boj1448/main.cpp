#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int N;
    cin >> N;

    vector<int> v(N);
    for(int i = 0; i < N; i++)
    {
        cin >> v[i];
    }
    sort(v.begin(), v.end());

    int answer = -1;
    for(int i = N-1; i >= 2; i--)
    {
        if(v[i] < v[i-1] + v[i-2])
        {
            answer = v[i] + v[i-1] + v[i-2];
            break;
        }
    }

    cout << answer;
    return 0;
}
