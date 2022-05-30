package boj24391;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
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

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        int preLec = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++){
            int lec = Integer.parseInt(st.nextToken());
            if(isSameParent(preLec, lec))continue;
            answer++;
            preLec = lec;
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
            parents[y] = x;
        }
    }

    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        return false;
    }
}
