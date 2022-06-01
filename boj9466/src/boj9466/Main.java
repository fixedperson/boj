package boj9466;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] team;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            team = new boolean[n+1];
            visited = new boolean[n+1];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++){
                dfs(i);
            }

            bw.write((n-count) + "\n");
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int now){
        if(visited[now])
            return;

        visited[now] = true;
        int next = arr[now];

        if(!visited[next])
            dfs(next);
        else{
            if(!team[next]){
                while(next != now){
                    count++;
                    next = arr[next];
                }
                count++;
            }
        }

        team[now] = true;
    }
}
