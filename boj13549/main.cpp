#include <bits/stdc++.h>

using namespace std;

class Node{
public:
    int x;
    int cnt;
    Node(int x, int cnt) : x(x), cnt(cnt) {}
};

struct cmp{
    bool operator()(Node a, Node b){
        if(a.cnt == b.cnt) return a.x > b.x;
        return a.cnt > b.cnt;
    }
};

bool isValid(int x){return x >= 0 && x <= 100000;}

int N, K;

int bfs(){
    if(N == K) return 0;

    priority_queue<Node, vector<Node>, cmp> pq;
    bool visited[100001] = {false};
    pq.push(*new Node(N, 0));
    visited[N] = true;

    while(!pq.empty()){
        Node node = pq.top();
        pq.pop();

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
            if(visited[nx]) continue;

            if(nx == K){
                if(i == 0) return node.cnt;
                else return node.cnt + 1;
            }

            if(i == 0) pq.push(*new Node(nx, node.cnt));
            else pq.push(*new Node(nx, node.cnt + 1));

            visited[nx] = true;
        }
    }
}

int main() {
    cin >> N >> K;
    cout << bfs();
    return 0;
}
