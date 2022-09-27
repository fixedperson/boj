package boj2083;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        while(true){
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            if(str.equals("#")) break;

            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            sb.append(str + " ");

            if(age > 17 || weight >= 80){
                sb.append("Senior");
            }
            else {
                sb.append("Junior");
            }
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));

        bw.close();
        br.close();
    }
}
