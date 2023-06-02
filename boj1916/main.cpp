#include <bits/stdc++.h>
#define INF 1e9

using namespace std;

int N, M;
int a, b;

vector<pair<int, int>> graph[1001];
int dist[1001];

void djikstra()
{
    priority_queue<pair<int, int>> pq;
    dist[a] = 0;
    pq.push({0, a});

    while(!pq.empty())
    {
        int now = pq.top().second;
        int weight = -pq.top().first;
        pq.pop();

        if(weight > dist[now]) continue;

        for(int i = 0; i < graph[now].size(); i++)
        {
            int next = graph[now][i].first;
            int cost = graph[now][i].second;

            if(dist[next] > weight + cost)
            {
                dist[next] = weight + cost;
                pq.push({-(weight + cost), next});
            }
        }
    }
}

int main()
{
    cin >> N >> M;

    for(int i = 0; i < M; i++)
    {
        int s, e, w;
        cin >> s >> e >> w;

        graph[s].push_back({e, w});
    }

    cin >> a >> b;
    fill_n(dist, 1001, INF);

    djikstra();

    cout << dist[b];
    return 0;
}
