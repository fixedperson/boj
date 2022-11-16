package boj2506;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int score = 1;
        st = new StringTokenizer(br.readLine());
        while(N-- > 0){
            if(Integer.parseInt(st.nextToken()) == 1) sum += score++;
            else score = 1;
        }

        bw.write(sum + "\n");

        bw.close();
        br.close();
    }
}
