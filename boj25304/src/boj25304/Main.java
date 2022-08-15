package boj25304;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int X = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sum += (a * b);
        }

        if(X == sum){
            bw.write("Yes");
        }
        else {
            bw.write("No");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
