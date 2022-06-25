package boj10216;

import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            parents = new int[N+1];
            for(int i = 0; i < N; i++){
                parents[i] = i;
            }

            List<Point> list = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());

                list.add(new Point(x,y,R));
            }

            for(int i = 0; i < N-1; i++){
                for(int j = i+1; j < N; j++){
                    Point a = list.get(i);
                    Point b = list.get(j);

                    if(Math.pow(a.x-b.x,2) + Math.pow(a.y-b.y,2) <= Math.pow(a.R + b.R, 2)){
                        union(i,j);
                    }
                }
            }

            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < N; i++){
                set.add(find(parents[i]));
            }

            bw.write(set.size() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int find(int x){
        if(x == parents[x])
            return x;
        else
            return parents[x] = find(parents[x]);
    }

    static void union(int x , int y){
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parents[y] = x;
            } else {
                parents[x] = y;
            }
        }
    }
}

class Point{
    int x;
    int y;
    int R;
    Point(int x, int y, int R){
        this.x = x;
        this.y = y;
        this.R = R;
    }
}