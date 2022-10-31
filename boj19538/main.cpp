#include <bits/stdc++.h>

using namespace std;

int *rumor;
vector<vector<int>> neigh;
queue<int> q;
set<int> s;
int cnt = 1;

void bfs(){
    while(!q.empty()){
        int size = q.size();
        for(int k = 0; k < size; k++){
            int temp = q.front();
            q.pop();

            for(const auto& i : neigh[temp]){
                if(rumor[i] != -1) continue;

                int rumorNum = 0;
                for(const auto& j : neigh[i]){
                    if(rumor[j] != -1) rumorNum++;
                }

                if(rumorNum >= neigh[i].size()/(double)2) {
                    s.insert(i);
                }
            }
        }

        for(const auto& i : s){
            q.push(i);
            rumor[i] = cnt;
        }
        s.clear();

        cnt++;
    }
}

int main() {
    using namespace std;

    int N, M;

    cin >> N;

    rumor = new int[N+1];

    neigh.push_back(vector<int>());
    for(int i = 1; i <= N; i++){
        rumor[i] = -1;
        neigh.push_back(vector<int>());
        while(true){
            int temp;
            cin >> temp;
            if(temp == 0) break;

            neigh[i].push_back(temp);
        }
    }

    cin >> M;

    for(int i = 0; i < M; i++){
        int temp;
        cin >> temp;
        q.push(temp);
        rumor[temp] = 0;
    }

    bfs();

    for(int i = 1; i <= N; i++){
        cout << rumor[i] << " ";
    }
    return 0;
}

