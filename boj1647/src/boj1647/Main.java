package boj1647;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.add(new Node(A,B,C));
        }

        int answer = 0;
        int last_cost = 0;
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            if(isSameParents(temp.start, temp.end)) continue;
            union(temp.start, temp.end);
            answer += temp.cost;
            last_cost = temp.cost;
        }
        answer = answer - last_cost;

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
    static int find(int x){
        if(x == parents[x])
            return x;
        else
            return parents[x] = find(parents[x]);
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(x < y){
                parents[y] = x;
            }
            else{
                parents[x] = y;
            }
        }
    }
    static boolean isSameParents(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        return false;
    }
}
class Node{
    int start;
    int end;
    int cost;
    Node(int start, int end, int cost){
        this.cost = cost;
        this.start = start;
        this.end = end;
    }
}