#include <bits/stdc++.h>

using namespace std;

vector<int> answer;
queue<int> q;

bool cmp(int a, int b){
    return answer[a] < answer[b];
}

int bfs(vector<vector<int>> v, vector<bool> visited) {
    q.push(1);
    visited[1] = true;

    int idx = 0;
    while(!q.empty()){
        int temp = q.front();
        q.pop();
        idx++;
        visited[temp] = true;

        if(answer[temp] != idx) return 0;

        for(int i : v[temp]) {
            if(visited[i]) continue;
            q.push(i);
        }
    }

    return 1;
}

int main() {
    int N;
    cin >> N;

    vector<vector<int>> v(N+1);
    vector<bool> visited(N+1);

    answer.assign(N+1, 0);

    for(int i = 0; i < N-1; i++){
        int a,b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    for(int i = 1; i <= N; i++){
        int a;
        cin >> a;
        answer[a] = i;
    }

    for(int i = 1; i <= N; i++){
        sort(v[i].begin(), v[i].end(), cmp);
    }

    cout << bfs(v, visited);
    return 0;
}
