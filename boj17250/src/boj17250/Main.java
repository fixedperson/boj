package boj17250;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int[] ranks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        ranks = new int[N+1];
        for(int i = 1; i <= N; i++){
            ranks[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
            bw.write(ranks[find(x)] + "\n");
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
            if(ranks[x] < ranks[y]) {
                int temp = y;
                y = x;
                x = temp;
            }
            parents[y] = x;
            ranks[x] += ranks[y];
        }
    }
}
