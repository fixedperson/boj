package boj2953;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int maxNum = 0;
        int maxSum = 0;

        for(int i = 1; i <= 5; i++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j = 0; j < 4; j++){
                sum += Integer.parseInt(st.nextToken());
            }

            if(maxSum < sum){
                maxNum = i;
                maxSum = sum;
            }
        }

        bw.write(maxNum + " " + maxSum);

        bw.close();
        br.close();
    }
}
