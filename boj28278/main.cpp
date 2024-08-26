#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N;
    cin >> N;

    vector<int> v;

    while(N -- > 0) {
        int cmd;
        int num;
        scanf("%d", &cmd);

        if(cmd == 1) {
            scanf("%d", &num);
            v.push_back(num);
        }

        else if (cmd == 2) {
            if(!v.empty()) {
                printf("%d\n", v.back());
                v.pop_back();
            }

            else {
                printf("-1\n");
            }
        }

        else if (cmd == 3) {
            printf("%d\n", v.size());
        }

        else if (cmd == 4) {
            if(v.empty()) {
                printf("1\n");
            }

            else {
                printf("0\n", v[0]);
            }
        }

        else if (cmd == 5) {
            if(!v.empty()) {
                printf("%d\n", v.back());
            }

            else {
                printf("-1\n");
            }
        }
    }
}
