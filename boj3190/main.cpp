#include <bits/stdc++.h>

using namespace std;

int N, K, L;
bool **visited;
queue<pair<int, int>> snake;
bool **apple;
unordered_map<int, char> dir_change;

int dir = 0;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int simulate() {
    int time = 0;

    queue<pair<int, int>> q;
    q.push(make_pair(1, 1));
    snake.push(make_pair(1, 1));
    visited[1][1] = true;

    while (!q.empty()) {
        time++;

        auto cur = q.front();
        q.pop();

        int nx = cur.first + dx[dir];
        int ny = cur.second + dy[dir];

        if(nx > N || ny > N || nx <= 0 || ny <= 0) break;
        if(visited[nx][ny]) break;

        q.push(make_pair(nx, ny));
        snake.push(make_pair(nx, ny));
        visited[nx][ny] = true;

        if(!apple[nx][ny]) {
            auto temp = snake.front();
            snake.pop();

            visited[temp.first][temp.second] = false;
        }
        else {
            apple[nx][ny] = false;
        }

        if(dir_change.find(time) != dir_change.end()) {
            if(dir_change[time] == 'L') {
                dir = (dir - 1 + 4) % 4;
            }

            else {
                dir = (dir + 1) % 4;
            }
        }
    }

    return time;
}

int main()
{
    cin >> N;
    visited = new bool*[N+1];
    for (int i = 0; i <= N; i++) {
        visited[i] = new bool[N+1];
        memset(visited[i], false, sizeof visited[i]);
    }

    apple = new bool*[N+1];
    for (int i = 0; i <= N; i++) {
        apple[i] = new bool[N+1];
        memset(apple[i], false, sizeof apple[i]);
    }

    cin >> K;
    for(int i = 0; i < K; i++) {
        int x, y;

        cin >> x >> y;
        apple[y][x] = true;
    }

    cin >> L;
    for(int i = 0; i < L; i++) {
        int x;
        char c;
        cin >> x >> c;

        dir_change.insert({x, c});
    }

    cout << simulate();
}
