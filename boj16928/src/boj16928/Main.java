package boj16928;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[101];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            hashMap.put(x, y);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            hashMap.put(x, y);
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        visited[1] = true;

        while(true){
            Node temp = queue.poll();

            for(int i = 1; i <= 6; i++){
                int nx = temp.x + i;

                if(!isValid(nx)) continue;
                if(visited[nx]) continue;
                if(nx == 100){
                    return temp.move + 1;
                }
                else if(hashMap.containsKey(nx)){
                    visited[nx] = true;
                    nx = hashMap.get(nx);
                }
                queue.add(new Node(nx, temp.move+1));
                visited[nx] = true;
            }
        }
    }
    static boolean isValid(int x){
        return (x > 0) && (x <= 100);
    }
}

class Node{
    int x;
    int move;

    Node(int x, int move){
        this.x = x;
        this.move = move;
    }
}