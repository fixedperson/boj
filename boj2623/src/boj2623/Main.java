package boj2623;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
            int num = Integer.parseInt(st.nextToken());
            int[] singers = new int[num];
            for(int j = 0; j < num; j++){
                singers[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < num-1; j++){
                for(int k = j+1; k < num; k++){
                    al.get(singers[j]).add(singers[k]);
                    indegree[singers[k]]++;
                }
            }
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
        for(int i = 1; i <= N; i++){
            if(indegree[i] != 0){
                System.out.println("0");
                System.exit(0);
            }
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
}