package boj1766;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<List<Integer>> al;
    static int[] indegree;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        al = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            al.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            indegree[B]++;
            al.get(A).add(B);
        }

        topologicalSort();

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
    static void topologicalSort(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0)
                pq.offer(i);
        }

        while(!pq.isEmpty()){
            int temp = pq.poll();
            sb.append(temp + " ");

            for (Integer i : al.get(temp)) {
                indegree[i]--;
                if(indegree[i] == 0)
                    pq.offer(i);
            }
        }
    }
}
