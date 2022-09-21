package boj11724;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[][] adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u][v] = true;
            adj[v][u] = true;
        }

        int count = 0;
        for(int i = 1; i <= N; i++){
            if(visited[i]) continue;
            dfs(i);
            count++;
        }

        bw.write(count + "\n");

        bw.close();
        br.close();
    }
    static void dfs(int start){
        visited[start] = true;
        for(int i = 1; i <= N; i++){
            if(adj[start][i] && !visited[i])
                dfs(i);
        }
    }
}
