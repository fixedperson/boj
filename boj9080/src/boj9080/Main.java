package boj9080;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine(), " :");

            int HH = Integer.parseInt(st.nextToken());
            int MM = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int fee = 0;

            while(D > 0){
                if((HH >= 22 || HH < 3) && D > 300){
                    while(HH != 8){
                        HH = (HH + 1) % 24;
                        D -= 60;
                    }

                    fee += 5000;
                    D += MM;
                    MM = 0;
                }
                else {
                    HH = (HH + 1) % 24;
                    D -= 60;
                    fee += 1000;
                }
            }

            bw.write(fee + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
