package boj14395;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int s, t;
    static char[] cals = {'*', '+', '-', '/'};
    static HashSet<Integer> visited = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        String answer = s == t ? "0" : bfs();

        bw.write(answer);

        bw.close();
        br.close();
    }
    static String bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(s, ""));
        visited.add(s);

        while(!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp.s == t) return temp.cal;

            for(int i = 0; i < 4; i++){
                long ns;
                if (i == 0){
                    ns = temp.s * temp.s;
                }

                else if(i == 1){
                    ns = temp.s + temp.s;
                }

                else if(i == 2){
                    ns = temp.s - temp.s;
                }

                else {
                    ns = temp.s / temp.s;
                }

                if(ns == 0) continue;
                if(ns > 2*t) continue;
                if(visited.contains(Math.toIntExact(ns))) continue;

                queue.add(new Node(ns, temp.cal + cals[i]));
                visited.add(Math.toIntExact(ns));
            }
        }

        return "-1";
    }
}

class Node{
    long s;
    String cal;

    Node(long s, String cal){
        this.s = s;
        this.cal = cal;
    }
}