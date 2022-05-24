package boj15809;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int[] ranks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        for(int i = 1; i <=N; i++){
            parents[i] = i;
        }

        ranks = new int[N+1];
        for(int i = 1; i <= N; i++){
            ranks[i] = Integer.parseInt(br.readLine());
        }


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int O = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            if(O == 1){
                union1(P, Q);
            }
            else{
                union2(P, Q);
            }
        }

        Arrays.sort(ranks);
        int count = 0;
        for(int i = 1; i <= N; i++){
            if(ranks[i] == 0) continue;
            count++;
            sb.append(ranks[i] + " ");
        }
        bw.write(count + "\n");
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
    static int find(int x){
        if(x==parents[x])
            return x;
        else
            return parents[x] = find(parents[x]);
    }
    static void union1(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(ranks[x] < ranks[y]){
                int temp = y;
                y = x;
                x = temp;
            }
            parents[y] = x;
            ranks[x] += ranks[y];
            ranks[y] = 0;
        }
    }
    static void union2(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y){
            if(ranks[x] == ranks[y]){
                ranks[x] = 0;
                ranks[y] = 0;
                return;
            }
            if(ranks[x] < ranks[y]){
                int temp = y;
                y = x;
                x = temp;
            }
            parents[y] = x;
            ranks[x] -= ranks[y];
            ranks[y] = 0;
        }
    }
}
