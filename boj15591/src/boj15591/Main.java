package boj15591;

import java.io.*;
import java.util.*;

public class Main {
    static int N, Q;
    static List<List<Node>> USADO;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        USADO = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            USADO.add(new ArrayList<>());
        }

        for(int i = 0; i < (N-1); i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            USADO.get(p).add(new Node(q, r));
            USADO.get(q).add(new Node(p, r));
        }

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(bfs(k,v) + "\n");
        }

        bw.write(String.valueOf(sb));

        bw.close();
        br.close();
    }
    static int bfs(int k, int v){
        int ans = 0;

        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N+1];

        visited[v] = true;
        queue.add(v);

        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(Node n : USADO.get(temp)){
                if(n.weight < k) continue;
                if(visited[n.end]) continue;

                queue.add(n.end);
                visited[n.end] = true;
                ans++;
            }
        }

        return ans;
    }
}

class Node{
    int end;
    int weight;
    Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
}