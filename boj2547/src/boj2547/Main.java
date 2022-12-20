package boj2547;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            br.readLine();
            int N = Integer.parseInt(br.readLine());

            BigInteger sum = new BigInteger("0");
            for(int i = 0; i < N; i++){
                sum = sum.add(new BigInteger(br.readLine()));
            }

            if(sum.remainder(new BigInteger(Integer.toString(N))) == BigInteger.ZERO) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.close();
        br.close();
    }
}
