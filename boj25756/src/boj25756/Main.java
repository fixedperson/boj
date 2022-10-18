package boj25756;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        double d = 1;
        while(N-- > 0){
            double A = Double.parseDouble(st.nextToken());

            d *= (1-(A/100));
            sb.append(((1 - d)*100)).append("\n");
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
