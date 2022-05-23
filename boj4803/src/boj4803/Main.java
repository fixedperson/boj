package boj4803;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0)
                break;
            parents = new int[n+1];
            for(int i = 1; i <= n; i++){
                parents[i] = i;
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(isSameParent(a,b))
                    union(a, 0);
                else
                    union(a, b);
            }

            Set<Integer> set = new HashSet<>();
            int answer;
            for(int i = 1; i <= n; i++){
                if(find(i) == 0)continue;
                set.add(find(i));
            }
            answer = set.size();

            bw.write("Case " + count++ + ": ");
            if(answer == 0)
                bw.write("No trees." + "\n");
            else if(answer == 1)
                bw.write("There is one tree." + "\n");
            else
                bw.write("A forest of " + answer + " trees." + "\n");
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
            if(x > y) {
                int temp = y;
                y = x;
                x = temp;
            }
            parents[y] = x;
        }
    }

    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        else
            return false;
    }
}
