package boj16562;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        parents = new int[N+1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        List<Friend> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            list.add(new Friend(i, Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            union(v,w);
        }

        int total_cost = 0;
        for(Friend i : list){
            if(!isSameParent(0, i.index)){
                union(0, i.index);
                total_cost += i.cost;
            }
        }

        if(total_cost <= k)
            bw.write(total_cost + "\n");
        else
            bw.write("Oh no");
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
            if(y < x){
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
        if(x==y)
            return true;
        return false;
    }
}

class Friend implements Comparable<Friend>{
    int index;
    int cost;
    Friend(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Friend o) {
        if(cost == o.cost)
            return index - o.index;
        return cost - o.cost;
    }
}