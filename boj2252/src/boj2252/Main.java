package boj2252;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N+1];

        ArrayList<List<Integer>> al = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            al.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            al.get(A).add(B);
            indegree[B]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            for (Integer i : al.get(temp)) {
                indegree[i]--;
                if(indegree[i] == 0)
                    q.offer(i);
            }
            sb.append(temp + " ");
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}
