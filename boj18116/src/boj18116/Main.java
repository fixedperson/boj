package boj18116;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static int[] ranks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parents = new int[1000001];
        for(int i = 1; i <= 1000000; i++){
            parents[i] = i;
        }

        ranks = new int[1000001];
        for(int i = 1; i <= 1000000; i++){
            ranks[i] = 1;
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("I")){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a,b);
            }

            else{
                int c = Integer.parseInt(st.nextToken());
                bw.write(ranks[find(c)] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static int find(int x){
        if(x == parents[x])
            return x;
        else
            return parents[x] = find(parents[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y) {
            if (ranks[x] < ranks[y]) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            parents[y] = x;
            ranks[x] += ranks[y];
        }
    }
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        else
            return false;
    }
}
