package boj20500;

import java.io.*;

public class Main {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N==1){
            System.out.println("0");
            System.exit(0);
        }

        dp = new long[3][N+1];
        dp[0][2] = 1;
        dp[1][2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[0][i] = (dp[1][i-1] + dp[2][i-1]) % 1000000007;
            dp[1][i] = (dp[0][i-1] + dp[2][i-1]) % 1000000007;
            dp[2][i] = (dp[0][i-1] + dp[1][i-1]) % 1000000007;
        }

        bw.write(dp[0][N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
