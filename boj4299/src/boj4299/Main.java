package boj4299;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());

        if(plus < minus || (plus+minus)%2!=0) bw.write("-1");
        else {
            int x = (plus + minus)/2;
            int y = (plus - minus)/2;

            bw.write(x + " " + y);
        }

        bw.close();
        br.close();
    }
}
