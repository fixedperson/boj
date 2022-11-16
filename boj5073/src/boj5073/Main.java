package boj5073;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0) break;

            int max = Math.max(Math.max(a,b),c);
            if(a == max) {
                if(a >= b+c) {
                    sb.append("Invalid\n");
                    continue;
                }
            }
            else if(b == max) {
                if(b >= a+c) {
                    sb.append("Invalid\n");
                    continue;
                }
            }
            else {
                if(c >= a+b) {
                    sb.append("Invalid\n");
                    continue;
                }
            }

            if(a== b && b == c) sb.append("Equilateral\n");
            else if(a!=b && b!=c && a!=c) sb.append("Scalene\n");
            else sb.append("Isosceles\n");
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
