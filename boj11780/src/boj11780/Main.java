package boj11780;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] dist;
    static int[][] pre;
    private static final int INF = 10000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n+1][n+1];
        pre = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = INF;
                if (i != j)
                    dist[i][j] = INF;
            }
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
            pre[a][b] = a;
        }
        for(int k = 1; k<= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j<=n; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(dist[i][j] >= INF) sb.append(0 + " ");
                else sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(pre[i][j] == INF) sb.append(0 + "\n");
                else{
                    int start = j;
                    stack.push(j);
                    while(pre[i][start] != i){
                        start = pre[i][start];
                        stack.push(start);
                    }
                    sb.append((stack.size()+1) + " ");
                    sb.append(i + " ");
                    while(!stack.isEmpty()){
                        sb.append(stack.pop() + " ");
                    }
                    sb.append("\n");
                }
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
