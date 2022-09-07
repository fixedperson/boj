package boj5014;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;
    static int[] dx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dx = new int[2];
        dx[0] = U;
        dx[1] = -D;

        int temp = bfs();
        String ans = temp == -1 ? "use the stairs" : String.valueOf(temp);

        bw.write(ans);

        bw.close();
        br.close();
    }
    static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[F+1];

        queue.add(new Node(S, 0));
        visited[S] = true;

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp.x == G) return temp.time;

            for(int i = 0; i < 2; i++){
                int nx = temp.x + dx[i];

                if(nx < 1 || nx > F) continue;
                if(visited[nx]) continue;

                queue.add(new Node(nx, temp.time+1));
                visited[nx] = true;
            }
        }

        return -1;
    }
}

class Node{
    int x, time;

    Node(int x, int time){
        this.x = x;
        this.time = time;
    }
}
