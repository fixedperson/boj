package boj5596;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = 0;
        for(int i = 0; i < 4 ; i++){
            a += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = 0;
        for(int i = 0; i < 4 ; i++){
            b += Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.max(a,b));
    }
}
