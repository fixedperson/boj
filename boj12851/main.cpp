#include <bits/stdc++.h>

using namespace std;

class Node{
public:
    int x;
    int second;
    Node(int x, int second) : x(x), second(second) {}
};

bool isValid(int x){return x >= 0 && x <= 100000;}

int N, K;

int second = 0, cnt = 0;

void bfs(){
    if(N == K) {
        cnt = 1;
        return;
    }

    queue<Node> pq;
    bool visited[100001] = {false};
    pq.push(*new Node(N, 0));
    visited[N] = true;

    while(!pq.empty()){
        Node node = pq.front();
        pq.pop();

        if(second != 0 && (node.second + 1) > second) return;

        visited[node.x] = true;

        for (int i = 0; i < 3; i++) {
            int nx;
            if(i == 0){
                nx = node.x * 2;
            }

            else if(i == 1){
                nx = node.x + 1;
            }

            else {
                nx = node.x - 1;
            }

            if(!isValid(nx)) continue;

            if(nx == K){
                second = node.second + 1;
                cnt++;
            }

            if(visited[nx]) continue;

            pq.push(*new Node(nx, node.second + 1));
        }
    }
}

int main() {
    cin >> N >> K;
    bfs();
    cout << second << "\n" << cnt;
    return 0;
}
