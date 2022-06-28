package boj1068;

import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> tree;
    static int[] parent;
    static int[] child_num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for(int i = 0; i < N; i++){
            tree.add(new ArrayList<>());
        }

        child_num = new int[N];
        parent = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp == -1) continue;
            tree.get(temp).add(i);
            parent[i] = temp;
            child_num[temp]++;
        }

        int delete = Integer.parseInt(br.readLine());
        if(delete != 0) {
            child_num[parent[delete]]--;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(delete);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(Integer i : tree.get(temp)){
                queue.add(i);
            }
            child_num[temp] = -1;
        }

        int answer = 0;
        for(int i = 0; i < N; i++){
            if(child_num[i] == 0) answer++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
