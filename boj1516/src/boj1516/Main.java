package boj1516;

import java.io.*;
import java.util.*;

public class Main {
    static int[] indegree;
    static int[] time;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        indegree = new int[N+1];
        time = new int[N+1];
        dp = new int[N+1];

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true){
                int x = Integer.parseInt(st.nextToken());
                if(x == -1)
                    break;
                list.get(x).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0) {
                queue.offer(i);
                dp[i] = time[i];
            }
        }

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(Integer i : list.get(temp)){
                indegree[i]--;
                dp[i] = Math.max(dp[i], dp[temp] + time[i]);
                if(indegree[i] == 0)
                    queue.offer(i);
            }
        }

        for(int i = 1; i <= N; i++){
            bw.write(dp[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
