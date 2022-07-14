package boj2493;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Node> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            while(true) {
                if(stack.size() == 0){
                    sb.append(0 + " ");
                    break;
                }
                else if (stack.peek().num < num) {
                    stack.pop();
                }
                else {
                    sb.append(stack.peek().index + " ");
                    break;
                }
            }
            stack.add(new Node(i, num));
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}

class Node{
    int index;
    int num;
    Node(int index, int num){
        this.index = index;
        this.num = num;
    }
}