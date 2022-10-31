#include <bits/stdc++.h>

int main() {
    using namespace std;

    int a, b, c;

    cin >> a >> b >> c;

    vector<int> arr;
    arr.push_back(a);
    arr.push_back(b);
    arr.push_back(c);

    sort(arr.begin(), arr.end());

    for(const auto& i : arr){
        cout << i << " ";
    }

    return 0;
}
