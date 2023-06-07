#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    long long N;
    cin >> N;

    long long ans = 0;
    while(N % 5 != 0)
    {
        N -= 3;
        ans++;
    }

    if (N < 0) cout << -1;
    else cout << ans + N / 5;

    return 0;
}
