package boj15789;

import java.io.*;
import java.util.Arrays;
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
            ranks[i] = 1;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            union(X, Y);
        }

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = ranks[find(C)];
        ranks[find(C)] = 0;
        ranks[find(H)] = 0;
        Arrays.sort(ranks);
        for(int i = 0; i < K; i++){
            answer += ranks[N-i];
        }

        bw.write(answer + "\n");
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
            if(ranks[y] > ranks[x]){
                int temp = y;
                y = x;
                x = temp;
            }
            parents[y] = x;
            ranks[x] += ranks[y];
            ranks[y] = 0;
        }
    }
}
