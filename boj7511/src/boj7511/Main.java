package boj7511;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++){
            bw.write("Scenario " + i + ":"+"\n");
            int n = Integer.parseInt(br.readLine());
            parents = new int[n+1];
            for(int j = 1; j <= n; j++){
                parents[j] = j;
            }
            int k = Integer.parseInt(br.readLine());
            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) + 1;
                int b = Integer.parseInt(st.nextToken()) + 1;

                union(a, b);
            }
            int m = Integer.parseInt(br.readLine());
            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) + 1;
                int v = Integer.parseInt(st.nextToken()) + 1;

                if(isSameParent(u,v)){
                    bw.write("1" + "\n");
                }
                else
                    bw.write("0" + "\n");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    static int find(int x){
        if(x == parents[x])
            return x;
        else
            return parents[x] = find(parents[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            parents[y] = x;
        }
    }

    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y)
            return true;
        else
            return false;
    }
}
