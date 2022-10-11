package boj11725;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parents;
    static List<List<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        for(int i = 0; i <= N; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        bfs();

        for(int i = 2; i <= N; i++){
            sb.append(parents[i] + "\n");
        }

        bw.write(String.valueOf(sb));

        bw.close();
        br.close();
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parents[1] = 1;

        while(!queue.isEmpty()){
            int temp = queue.poll();

            for(Integer i : tree.get(temp)){
                if(parents[i] == 0){
                    parents[i] = temp;
                    queue.add(i);
                }
            }
        }
    }
}
