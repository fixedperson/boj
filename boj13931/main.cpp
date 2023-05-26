#include <bits/stdc++.h>

using namespace std;

class Node{
public:
    int x;
    int second;
    Node(int x, int second) : x(x), second(second){}
};

bool isValid(int x){return x >= 0 && x <= 100000;}

int N, K;

int second;
string root;
vector<int> trace_vec;

string trace(){
    int cur = K;
    stack<int> stack1;
    while(cur != N){
        stack1.push(cur);
        cur = trace_vec[cur];
    }

    string s;
    s += to_string(N) + " ";
    while(!stack1.empty()){
        s += to_string(stack1.top()) + " ";
        stack1.pop();
    }

    return s;
}

void bfs(){
    if(N == K){
        second = 0;
        root = trace();
        return;
    }

    queue<Node> pq;
    bool visited[100001] = {false};
    pq.push(*new Node(N, 0));
    visited[N] = true;

    while(!pq.empty()){
        Node node = pq.front();
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

            pq.push(*new Node(nx, node.second + 1));
            trace_vec[nx] = node.x;
            visited[nx] = true;

            if(nx == K){
                second = node.second + 1;
                root = trace();
                return;
            }
        }
    }
}

int main() {
    cin >> N >> K;
    trace_vec.assign(100001, -1);
    trace_vec[N] = N;
    bfs();
    cout << second << "\n" << root;
    return 0;
}
