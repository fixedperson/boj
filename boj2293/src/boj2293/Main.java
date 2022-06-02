package boj2293;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] coin;
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[k+1];
        coin = new int[n];
        for(int i = 0; i < n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= k; j++){
                if(j - coin[i] >= 0)
                    dp[j] += dp[j-coin[i]];
            }
        }

        bw.write(dp[k] + "\n");
        bw.flush();
        bw.close();
    }
}
