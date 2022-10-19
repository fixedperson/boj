package boj1009;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int answer = 1;
            int temp = a % 10;
            for(int i = 0; i < b; i++){
                answer *= temp;
                answer %= 10;
            }

            sb.append(answer == 0 ? "10" : answer).append("\n");
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
