package boj17471;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] people;
    static List<List<Integer>> map;
    static boolean[] isWardA;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        people = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        map = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            map.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            while(size-- > 0){
                map.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        isWardA = new boolean[N+1];
        select(1);

        bw.write(String.valueOf(ans == Integer.MAX_VALUE ? -1 : ans));

        bw.close();
        br.close();
    }
    static void select(int index){
        if(index == N + 1){
            if(isLinked()){
                int sumA = 0, sumB = 0;
                for(int i = 1; i <= N; i++){

                    if(isWardA[i]) sumA += people[i];
                    else sumB += people[i];
                }
                ans = Math.min(Math.abs(sumA - sumB), ans);
            }

            return;
        }

        isWardA[index] = true;
        select(index + 1);

        isWardA[index] = false;
        select(index + 1);
    }
    static boolean isLinked(){
        boolean[] visited = new boolean[N+1];

        int wardA = -1, wardB = -1;

        for(int i = 1; i <= N; i++){
            if(isWardA[i]){
                wardA = i;
                break;
            }
        }

        for(int i = 1; i <= N; i++){
            if(!isWardA[i]){
                wardB = i;
                break;
            }
        }

        if(wardA == -1 || wardB == -1) return false;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(wardA);
        visited[wardA] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(Integer i : map.get(temp)){
                if(visited[i]) continue;
                if(!isWardA[i]) continue;

                visited[i] = true;
                queue.add(i);
            }
        }

        queue.add(wardB);
        visited[wardB] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(Integer i : map.get(temp)){
                if(visited[i]) continue;
                if(isWardA[i]) continue;

                visited[i] = true;
                queue.add(i);
            }
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i])
                return false;
        }

        return true;
    }
}
