#include <bits/stdc++.h>

using namespace std;

class Node{
public:
    int x, y;

    Node(int x, int y){
        this->x = x;
        this->y = y;
    }
};

vector<Node> vec;
bool *visited;
int homeX, homeY;
int fesX, fesY;

string bfs(){
    queue<Node> q;
    q.push(Node(homeX, homeY));
    while(!q.empty()){
        auto temp = q.front();
        q.pop();

        if(abs(temp.x - fesX) + abs(temp.y - fesY) <= 1000) return "happy";

        for(int i = 0; i < vec.size(); i++){
            if(visited[i]) continue;

            if(abs(temp.x - vec[i].x) + abs(temp.y - vec[i].y) <= 1000){
                q.push(vec[i]);
                visited[i] = true;
            }
        }
    }
    return "sad";
}

int main() {
    int t;
    cin >> t;
    while(t-- > 0){
        int n;
        cin >> n;

        cin >> homeX >> homeY;
        if(n != 0) visited = new bool[n]{false};
        for(int i = 0; i < n; i++){
            int x, y;
            cin >> x >> y;
            vec.insert(vec.begin()+i, Node(x, y));
        }
        cin >> fesX >> fesY;
        cout << bfs() << "\n";
        vec.clear();
    }
    return 0;
}
