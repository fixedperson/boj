package boj2480;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int ans = 0;
        if(a == b && b == c){
            ans = 10000 + a * 1000;
        }
        else if(a != b && b != c && a != c){
            ans = Math.max(a, Math.max(b, c)) * 100;
        }
        else {
            if(a == b){
                ans = 1000 + a * 100;
            }
            else {
                ans = 1000 + c * 100;
            }
        }

        bw.write(ans + "\n");

        bw.close();
        br.close();
    }
}
