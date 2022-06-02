package boj1005;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[] indegree;
    static int[] time;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i <= N; i++){
                list.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            time = new int[N+1];
            for(int i = 1; i <= N; i++){
                time[i] = Integer.parseInt(st.nextToken());
            }
            indegree = new int[N+1];
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                list.get(X).add(Y);
                indegree[Y]++;
            }
            dp = new int[N+1];

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
                    if(indegree[i] == 0){
                        queue.offer(i);
                    }
                }
            }

            int answer = dp[Integer.parseInt(br.readLine())];
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
