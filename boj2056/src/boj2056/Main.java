package boj2056;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int[] indegree;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        dp = new int[N+1];
        indegree = new int[N+1];
        time = new int[N+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            time[i] = a;
            indegree[i] = b;

            for(int j = 0; j < b; j++){
                list.get(Integer.parseInt(st.nextToken())).add(i);
            }
        }

        int max = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            dp[i] = time[i];
            if(indegree[i] == 0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(Integer i : list.get(temp)){
                indegree[i]--;
                dp[i] = Math.max(dp[i], dp[temp] + time[i]);
                if(indegree[i] == 0)
                    queue.add(i);
            }

            max = Math.max(dp[temp], max);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
