package boj1837;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger P = new BigInteger(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String answer = "GOOD";
        int r = 0;
        for(int i = 2; i < K; i++){
            if(P.remainder(new BigInteger(Integer.toString(i))).equals(BigInteger.ZERO)){
                answer = "BAD";
                r = i;
                break;
            }
        }

        bw.write(answer.equals("GOOD") ? answer : (answer + " " + r));

        bw.close();
        br.close();
    }
}
