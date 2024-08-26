#include <bits/stdc++.h>

using namespace std;

int main()
{
    string batch;
    cin >> batch;

    int sum = 0;
    int stick = 0;
    for(int i = 0; i < batch.size(); i++) {
        if(batch[i] == '(') {
            stick++;
        }

        else {
            stick--;
            if(batch[i-1] == '(') {
                sum += stick;
            }

            else {
                sum += 1;
            }
        }
    }

    cout << sum;
}
