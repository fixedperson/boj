package boj2644;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int start, end;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        bw.write(bfs() + "\n");

        bw.close();
        br.close();
    }
    static int bfs(){

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start] = true;
        while(!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp.num == end) return temp.count;

            for(Integer i : list.get(temp.num)){
                if(visited[i]) continue;

                queue.add(new Node(i, temp.count+1));
                visited[i] = true;
            }
        }

        return -1;
    }
}
class Node{
    int num, count;

    Node(int num, int count){
        this.num = num;
        this.count = count;
    }
}