package boj25428;

import java.io.*;
import java.util.*;

public class Main {
    static int[] chalk;
    static int[] parents;
    static int[] ranks;
    static long[] minChalk;
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        chalk = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            chalk[i] = Integer.parseInt(st.nextToken());
            answer = Math.max(chalk[i], answer);
        }

        minChalk = new long[N+1];
        Arrays.fill(minChalk, 1000001);

        parents = new int[N+1];
        ranks = new int[N+1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
            ranks[i] = 1;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Math.min(chalk[o2.u], chalk[o2.v]) - Math.min(chalk[o1.u], chalk[o1.v]);
            }
        });
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            pq.add(new Node(u, v));
        }

        while(!pq.isEmpty()){
            Node temp = pq.poll();

            int parent = union(temp.u, temp.v);

            answer = Math.max(answer, ranks[parent] * minChalk[parent]);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static int find(int x){
        if(x == parents[x]){
            return x;
        }
        else {
            return parents[x] = find(parents[x]);
        }
    }

    static int union(int x, int y){
        int min = Math.min(chalk[x], chalk[y]);

        x = find(x);
        y = find(y);

        if(x == y)
            return x;

        if(ranks[x] < ranks[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        parents[y] = x;
        ranks[x] += ranks[y];
        minChalk[x] = Math.min(minChalk[x], min);

        return x;
    }
}
class Node{
    int u;
    int v;
    Node(int u, int v){
        this.u = u;
        this.v = v;
    }
}